package com.github.fhbjeeweb.web.controller;

import java.util.TreeSet;

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

	public TreeSet<Genre> getGenres() {
		// Convert List to TreeSet so that genres are sorted alphabetically
		return new TreeSet<Genre>(manager.readGenres());
	}

	public String editGenre() {
		return Pages.EDIT_GENRE;
	}
}