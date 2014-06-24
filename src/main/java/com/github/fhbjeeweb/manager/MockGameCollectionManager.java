package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Named(value = "manager")
@javax.enterprise.context.SessionScoped
public class MockGameCollectionManager implements Manager, Serializable {
    private static final long serialVersionUID = -3965156883166963384L;

    private Set<Game> games;

    public MockGameCollectionManager() {
        games = new TreeSet<>();
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void deleteAllGames() {
        games.clear();
    }
}
