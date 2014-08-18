package com.github.gandom.steam.data;

import java.util.List;

public class ResponseGame {
	private Number game_count;
	private List<?> games;

	public Number getGame_count() {
		return this.game_count;
	}

	public void setGame_count(Number game_count) {
		this.game_count = game_count;
	}

	public List<?> getGames() {
		return this.games;
	}

	public void setGames(List<?> games) {
		this.games = games;
	}
}
