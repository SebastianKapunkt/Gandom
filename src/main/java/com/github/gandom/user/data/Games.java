package com.github.gandom.user.data;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Games {
	private String steamid;
	private Number game_count;
	private Set<Game> games;

	public Games(){
		steamid = null;
	}
	
	public Games(String steamid){
		this.steamid = steamid;
	}
	
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

	public String getSteamid() {
		return steamid;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}
}
