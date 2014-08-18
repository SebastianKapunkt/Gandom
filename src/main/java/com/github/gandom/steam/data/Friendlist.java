package com.github.gandom.steam.data;

import java.util.Set;

import com.github.gandom.data.Friend;

public class Friendlist {
	private Set<Friend> friends;

	public Set<Friend> getFriends() {
		return this.friends;
	}

	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}
}
