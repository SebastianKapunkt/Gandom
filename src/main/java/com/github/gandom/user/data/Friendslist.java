package com.github.gandom.user.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Friendslist {
	private String steamid;
	private List<Friend> friends;

	public Friendslist(){
		steamid = null;
		friends = null;
	}
	
	public Friendslist(String steamid){
		this.steamid = steamid;
	}
	
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
