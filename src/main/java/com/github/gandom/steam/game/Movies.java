package com.github.gandom.steam.game;

public class Movies {
	private boolean highlight;
	private String id;
	private String name;
	private String thumbnail;
	private Webm webm;

	public boolean getHighlight() {
		return this.highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Webm getWebm() {
		return this.webm;
	}

	public void setWebm(Webm webm) {
		this.webm = webm;
	}
}
