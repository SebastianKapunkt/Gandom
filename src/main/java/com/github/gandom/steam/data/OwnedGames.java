package com.github.gandom.steam.data;

import java.util.Set;

import com.github.gandom.data.Game;

public class OwnedGames {
	private Number game_count;
	private Set<Game> games;

	public Number getGame_count() {
		return this.game_count;
	}

	public void setGame_count(Number game_count) {
		this.game_count = game_count;
	}

	public Set<Game> getGames() {
		return this.games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
}
