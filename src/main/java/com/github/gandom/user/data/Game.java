package com.github.gandom.user.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	private Number appid;
	private Number playtime_forever;

	public Number getAppid() {
		return this.appid;
	}

	public void setAppid(Number appid) {
		this.appid = appid;
	}

	public Number getPlaytime_forever() {
		return this.playtime_forever;
	}

	public void setPlaytime_forever(Number playtime_forever) {
		this.playtime_forever = playtime_forever;
	}
}
