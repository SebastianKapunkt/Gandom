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

    public MockGameCollectionManager() {
        games = generateExampleEntries();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    private List<Game> generateExampleEntries() {
        List<Game> games = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            games.add(new Game("Game " + i, "Publisher " + i, "Genre " + i));
        }
        return games;
    }
}
