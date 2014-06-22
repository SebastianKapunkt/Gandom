package com.github.fhbjeeweb.web.controller;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.manager.Manager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddGameController {
    @Inject
    private Manager manager;
    private Game game;

    @PostConstruct
    private void initGame() {
        game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String save() {
        manager.addGame(game);
        return Pages.LIST_GAMES;
    }

    public String cancel() {
        return Pages.LIST_GAMES;
    }
}