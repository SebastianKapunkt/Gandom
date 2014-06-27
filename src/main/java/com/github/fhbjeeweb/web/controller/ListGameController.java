package com.github.fhbjeeweb.web.controller;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.manager.GameManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.TreeSet;

@Named
@RequestScoped
public class ListGameController {
	@Inject
	private GameManager manager;

	public TreeSet<Game> getGames() {
		// Convert List to TreeSet so that games are sorted alphabetically
		return new TreeSet<Game>(manager.readGames());
	}

	public String addGame() {
		return Pages.ADD_GAME;
	}

	public String editGame() {
		return Pages.EDIT_GAME;
	}
}