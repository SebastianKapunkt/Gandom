package com.github.gandom.steam.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metacritic {
	private Number score;
	private String url;

	public Number getScore() {
		return this.score;
	}

	public void setScore(Number score) {
		this.score = score;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
