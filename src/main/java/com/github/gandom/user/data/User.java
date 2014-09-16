package com.github.gandom.user.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
	private String avatar;
	private String avatarfull;
	private String avatarmedium;
	private Number communityvisibilitystate;
	private Number lastlogoff;
	private String personaname;
	private Number personastate;
	private Number personastateflags;
	private String primaryclanid;
	private Number profilestate;
	private String profileurl;
	private String steamid;
	private Number timecreated;

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarfull() {
		return this.avatarfull;
	}

	public void setAvatarfull(String avatarfull) {
		this.avatarfull = avatarfull;
	}

	public String getAvatarmedium() {
		return this.avatarmedium;
	}

	public void setAvatarmedium(String avatarmedium) {
		this.avatarmedium = avatarmedium;
	}

	public Number getCommunityvisibilitystate() {
		return this.communityvisibilitystate;
	}

	public void setCommunityvisibilitystate(Number communityvisibilitystate) {
		this.communityvisibilitystate = communityvisibilitystate;
	}

	public Number getLastlogoff() {
		return this.lastlogoff;
	}

	public void setLastlogoff(Number lastlogoff) {
		this.lastlogoff = lastlogoff;
	}

	public String getPersonaname() {
		return this.personaname;
	}

	public void setPersonaname(String personaname) {
		this.personaname = personaname;
	}

	public Number getPersonastate() {
		return this.personastate;
	}

	public void setPersonastate(Number personastate) {
		this.personastate = personastate;
	}

	public Number getPersonastateflags() {
		return this.personastateflags;
	}

	public void setPersonastateflags(Number personastateflags) {
		this.personastateflags = personastateflags;
	}

	public String getPrimaryclanid() {
		return this.primaryclanid;
	}

	public void setPrimaryclanid(String primaryclanid) {
		this.primaryclanid = primaryclanid;
	}

	public Number getProfilestate() {
		return this.profilestate;
	}

	public void setProfilestate(Number profilestate) {
		this.profilestate = profilestate;
	}

	public String getProfileurl() {
		return this.profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public String getSteamid() {
		return this.steamid;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}

	public Number getTimecreated() {
		return this.timecreated;
	}

	public void setTimecreated(Number timecreated) {
		this.timecreated = timecreated;
	}
}
