package com.github.fhbjeeweb.web.controller;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.manager.GameManager;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class EditGameController implements Serializable {

    private static final long serialVersionUID = 9076956898416029342L;

    @Inject
    private GameManager manager;

    private long persistedGameId;
    private Game game;

    public long getPersistedGameId() {
        return persistedGameId;
    }

    public void setPersistedGameId(long persistedGameId) {
        this.persistedGameId = persistedGameId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void loadGame() {
        game = manager.getGameById(persistedGameId);
    }

    public String save() {
        game.getPublisher().setId(null);
        manager.editGame(game);
        return Pages.LIST_GAMES;
    }

    public String cancel() {
        return Pages.LIST_GAMES;
    }
}