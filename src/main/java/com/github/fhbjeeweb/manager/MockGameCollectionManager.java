package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

@ManagedBean(name = "manager")
@SessionScoped
public class MockGameCollectionManager implements Manager {
    private Set<Game> games;
    private HashMap<String, String> userInput;

    public MockGameCollectionManager() {
        games = new TreeSet<>();
        userInput = new HashMap<>();
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public HashMap<String, String> getUserInput() {
        return userInput;
    }

    public void setUserInput(HashMap<String, String> userInput) {
        this.userInput = userInput;
    }

    // JSF Actions
    public String addGame() {
        Game game = new Game(
                userInput.get("gameTitle"),
                userInput.get("gamePublisher"),
                userInput.get("gameGenres"));
        games.add(game);
        userInput.clear();
        return "/listGames";
    }

    public String cancel() {
        return "/listGames";
    }

    public String navigateToAddGame() {
        return "/addGame";
    }
}
