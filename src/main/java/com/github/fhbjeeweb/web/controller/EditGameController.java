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
public class EditGameController {
	@Inject
	private GameManager manager;

	private long persistedGameId;
	private Game game;

	@PostConstruct
	private void initGame() {
		game = new Game();
		game.setPublisher(new Publisher());
	}

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
		/* TODO FIX LOSE OF ID */
		game.setId(manager.getGameById(persistedGameId).getId());
		game.setIsEdited(true);
		manager.saveGame(game);
		return Pages.LIST_GAMES;
	}

	public String cancel() {
		return Pages.LIST_GAMES;
	}
}