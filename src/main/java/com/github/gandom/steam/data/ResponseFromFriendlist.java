package com.github.gandom.steam.data;

import com.github.gandom.data.Friendlist;

public class ResponseFromFriendlist {
	private Friendlist friendslist;

	public Friendlist getFriendslist() {
		return this.friendslist;
	}

	public void setFriendslist(Friendlist friendslist) {
		this.friendslist = friendslist;
	}
}
