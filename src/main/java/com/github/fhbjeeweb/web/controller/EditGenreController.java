package com.github.fhbjeeweb.web.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.fhbjeeweb.data.Genre;
import com.github.fhbjeeweb.manager.GameManager;

@Named
@RequestScoped
public class EditGenreController {

	@Inject
	private GameManager manager;
	
	private long persitedGenreId;
	private Genre genre;
	
	@PostConstruct
	private void initGenre(){
		genre = new Genre();
	}

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
