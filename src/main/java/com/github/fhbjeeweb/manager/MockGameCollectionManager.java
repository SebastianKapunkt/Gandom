package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "manager")
@SessionScoped
public class MockGameCollectionManager implements Manager {
    private List<Game> games;
    // Properties used by addGame() action when a new game is added to the list
    private String gameTitle;
    private String gamePublisher;
    private String gameGenres;

    public MockGameCollectionManager() {
        games = generateExampleEntries();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGamePublisher() {
        return gamePublisher;
    }

    public void setGamePublisher(String gamePublisher) {
        this.gamePublisher = gamePublisher;
    }

    public String getGameGenres() {
        return gameGenres;
    }

    public void setGameGenres(String gameGenres) {
        this.gameGenres = gameGenres;
    }

    // JSF Actions
    // FIXME: Do not add duplicate entries to the list
    public String addGame() {
        Game game = new Game(gameTitle, gamePublisher, gameGenres);
        games.add(game);
        return "/listGames";
    }

    public String cancel() {
        return "/listGames";
    }

    public String navigateToAddGame() {
        return "/addGame";
    }

    private List<Game> generateExampleEntries() {
        List<Game> games = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            games.add(new Game("Game " + i, "Publisher " + i, "Genre " + i));
        }
        return games;
    }
}
