package com.github.fhbjeeweb.web.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController {

	public String showRandomGame() {
		return Pages.RANDOMGAME;
	}

	public String showGameCollection() {
		return Pages.LIST_GAMES;
	}

	public String showAddGame() {
		return Pages.ADD_GAME;
	}

	public String showPublisherList() {
		return Pages.LIST_PUBLISHERS;
	}

	public String showGenreList() {
		return Pages.LIST_GENRES;
	}

	public String showRangam() {
		return Pages.RANGAM;
	}
}