package com.github.gandom.steam.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Webm {
	@JsonProperty("480")
	private String p480;
	private String max;

	public String getp480() {
		return this.p480;
	}

	public void set480(String p480) {
		this.p480 = p480;
	}

	public String getMax() {
		return this.max;
	}

	public void setMax(String max) {
		this.max = max;
	}
}
