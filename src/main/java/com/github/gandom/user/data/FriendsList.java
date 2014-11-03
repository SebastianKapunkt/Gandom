package com.github.gandom.user.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendsList {
	private String steamid;
	private List<Friend> friends;

	public List<Friend> getFriends() {
		return this.friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public String getSteamid() {
		return steamid;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}
}
