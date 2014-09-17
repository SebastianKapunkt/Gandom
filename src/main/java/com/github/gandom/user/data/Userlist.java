package com.github.gandom.user.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Userlist {
	private List<User> Userlist;

	public List<User> getUserlist() {
		return this.Userlist;
	}

	public void setUserlist(List<User> players) {
		this.Userlist = players;
	}
}
