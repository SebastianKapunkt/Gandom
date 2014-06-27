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
        // If the user changes the publisher name, we do NOT want to rename the
        // publisher across all games but only change the publisher for this
        // single game. Thus we have to remove the old id
        game.getPublisher().setId(null);
    }

    public String save() {
        manager.editGame(game);
        return Pages.LIST_GAMES;
    }

    public String cancel() {
        return Pages.LIST_GAMES;
    }
}