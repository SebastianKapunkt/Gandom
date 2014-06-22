package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;

import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

@Named(value = "manager")
@javax.enterprise.context.SessionScoped
public class MockGameCollectionManager implements Manager, Serializable {
    private static final long serialVersionUID = -3965156883166963384L;
    private static final String LIST_GAMES_VIEW_ID = "/listGames";
    private static final String ADD_GAME_VIEW_ID = "/addGame";

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
    public String deleteAll() {
        games.clear();
        return LIST_GAMES_VIEW_ID;
    }

    public String addGame() {
        Game game = new Game(
                userInput.get("gameTitle"),
                userInput.get("gamePublisher"),
                userInput.get("gameGenres"));
        games.add(game);
        userInput.clear();
        return LIST_GAMES_VIEW_ID;
    }

    public String cancel() {
        return LIST_GAMES_VIEW_ID;
    }

    public String navigateToAddGame() {
        return ADD_GAME_VIEW_ID;
    }
}
