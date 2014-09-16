package com.github.gandom.user.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Games {
	private String steamid;
	private Number game_count;
	private List<Game> games;

	public Number getGame_count() {
		return this.game_count;
	}

	public void setGame_count(Number game_count) {
		this.game_count = game_count;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public String getSteamid() {
		return steamid;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}
}
