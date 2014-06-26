package com.github.fhbjeeweb.web.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.fhbjeeweb.data.Genre;
import com.github.fhbjeeweb.manager.GameManager;

@Named
@ViewScoped
public class EditGenreController {

	@Inject
	private GameManager manager;
	
	private long persitedGenreId;
	private Genre genre;
	
	public long getPersitedGenreId() {
		return persitedGenreId;
	}

	public void setPersitedGenreId(long persitedGenreId) {
		this.persitedGenreId = persitedGenreId;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public void loadGenre() {
		genre = manager.getGenreById(persitedGenreId);
	}
	
	public String save(){
		genre.setId(persitedGenreId);
		manager.saveGenre(genre);
		return Pages.LIST_GENRES;
	}
	
	public String cancel(){
		return Pages.LIST_GENRES;
	}
}
