package com.github.fhbjeeweb.web.controller;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.manager.Manager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Set;

@Named
@RequestScoped
public class ListGameController {
    @Inject
    private Manager manager;

    public Set<Game> getGames() {
        return manager.getGames();
    }

    public String addGame() {
        return Pages.ADD_GAME;
    }

    public String deleteAll() {
        manager.deleteAllGames();
        return Pages.LIST_GAMES;
    }
}