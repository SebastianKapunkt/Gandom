package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;

import java.util.Set;

public interface Manager {
    Set<Game> getGames();

    void setGames(Set<Game> games);

    void addGame(Game game);

    void deleteAllGames();
}
