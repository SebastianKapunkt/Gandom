package com.github.gandom.steam.data;

public class Friends {
	private Number friend_since;
	private String relationship;
	private String steamid;

	public Number getFriend_since() {
		return this.friend_since;
	}

	public void setFriend_since(Number friend_since) {
		this.friend_since = friend_since;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getSteamid() {
		return this.steamid;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}
}
