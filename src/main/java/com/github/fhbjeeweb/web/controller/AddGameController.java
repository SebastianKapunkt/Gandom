package com.github.fhbjeeweb.web.controller;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.data.Publisher;
import com.github.fhbjeeweb.manager.GameManager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddGameController {
    @Inject
    private GameManager manager;

    private Game game;

    @PostConstruct
    private void initGame() {
        game = new Game();
        game.setPublisher(new Publisher());
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String save() {
        manager.saveGame(game);
        return Pages.LIST_GAMES;
    }

    public String cancel() {
        return Pages.LIST_GAMES;
    }
}