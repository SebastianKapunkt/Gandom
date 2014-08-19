package com.github.gandom.steam.game;

import java.util.List;

public class Achievements {
	private List<Highlighted> highlighted;
	private Number total;

	public List<?> getHighlighted() {
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
