package com.github.gandom.user.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Friend {
	private Number friend_since;
	private String relationship;
	private String steamid;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((steamid == null) ? 0 : steamid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Friend)) {
			return false;
		}
		Friend other = (Friend) obj;
		if (steamid == null) {
			if (other.steamid != null) {
				return false;
			}
		} else if (!steamid.equals(other.steamid)) {
			return false;
		}
		return true;
	}
	
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
