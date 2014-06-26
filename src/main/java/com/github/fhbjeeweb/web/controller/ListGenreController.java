package com.github.fhbjeeweb.web.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.fhbjeeweb.data.Genre;
import com.github.fhbjeeweb.manager.GameManager;

@Named
@RequestScoped
public class ListGenreController {

	@Inject
	private GameManager manager;

	public List<Genre> getGenres(){
		return manager.readGenres();
	}
	
	public String editGenre(){
		return Pages.EDIT_GENRE;
	}
}