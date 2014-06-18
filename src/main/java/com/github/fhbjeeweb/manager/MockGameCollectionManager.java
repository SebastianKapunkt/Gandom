package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Set;
import java.util.TreeSet;

@ManagedBean(name = "manager")
@SessionScoped
public class MockGameCollectionManager implements Manager {
    private Set<Game> games;
    // Properties used by addGame() action when a new game is added to the list
    private String gameTitle;
    private String gamePublisher;
    private String gameGenres;

    public MockGameCollectionManager() {
        games = new TreeSet<>();
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
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
    public String addGame() {
        Game game = new Game(gameTitle, gamePublisher, gameGenres);
        games.add(game);
        // reset parameters
        gameTitle = null;
        gamePublisher = null;
        gameGenres = null;
        return "/listGames";
    }

    public String cancel() {
        return "/listGames";
    }

    public String navigateToAddGame() {
        return "/addGame";
    }
}
