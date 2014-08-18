package com.github.gandom.data;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Friend {
	private Number friend_since;
	private String relationship;
	private String steamid;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
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
