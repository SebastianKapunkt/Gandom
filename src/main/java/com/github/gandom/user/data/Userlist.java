package com.github.gandom.user.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Userlist {
	private List<User> Userlist;

	public List<User> getPlayers() {
		return this.Userlist;
	}

	public void setPlayers(List<User> players) {
		this.Userlist = players;
	}
}
