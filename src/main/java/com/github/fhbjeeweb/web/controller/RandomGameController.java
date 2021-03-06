package com.github.fhbjeeweb.web.controller;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.manager.GameManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RandomGameController {

    @Inject
    private GameManager manager;

    private Game game;

    public Game getGame() {
        return this.game;
    }

    public void rangam() {
        game = manager.selectRandomGame();
    }
}