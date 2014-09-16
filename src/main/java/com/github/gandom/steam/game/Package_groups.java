package com.github.gandom.steam.game;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Package_groups {
	private String description;
	private String display_type;
	private String is_recurring_subscription;
	private String name;
	private String save_text;
	private String selection_text;
	private List<?> subs;
	private String title;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplay_type() {
		return this.display_type;
	}

	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}

	public String getIs_recurring_subscription() {
		return this.is_recurring_subscription;
	}

	public void setIs_recurring_subscription(String is_recurring_subscription) {
		this.is_recurring_subscription = is_recurring_subscription;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSave_text() {
		return this.save_text;
	}

	public void setSave_text(String save_text) {
		this.save_text = save_text;
	}

	public String getSelection_text() {
		return this.selection_text;
	}

	public void setSelection_text(String selection_text) {
		this.selection_text = selection_text;
	}

	public List<?> getSubs() {
		return this.subs;
	}

	public void setSubs(List<?> subs) {
		this.subs = subs;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
