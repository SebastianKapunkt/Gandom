package com.github.gandom.steam.app;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Achievements {
	private List<Highlighted> highlighted;
	private Number total;

	public List<Highlighted> getHighlighted() {
		return this.highlighted;
	}

	public void setHighlighted(List<Highlighted> highlighted) {
		this.highlighted = highlighted;
	}

	public Number getTotal() {
		return this.total;
	}

	public void setTotal(Number total) {
		this.total = total;
	}
}
