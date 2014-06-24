package com.github.fhbjeeweb.web.controller;

import java.util.HashSet;
import java.util.Set;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.data.Genre;
import com.github.fhbjeeweb.data.Publisher;
import com.github.fhbjeeweb.manager.GameManager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddGameController {
	@Inject
	private GameManager manager;
	private Game game;
	private Publisher publisher;
//	private Genre genre;
	private String genreString;
	private Set<Game> games;
	private Set<Genre> genres;

	@PostConstruct
	private void initGame() {
		publisher = new Publisher();
//		genre = new Genre();
		genreString = "";
		game = new Game();
		// TODO: Use a set in the first place
		games = new HashSet<Game>(manager.readGames());
		genres = new HashSet<Genre>(manager.readGenres());
		// games.addAll(manager.readGames());
	}

	 public Game getGame() {
	 return game;
	 }

	public void setGame(Game game) {
		this.game = game;
	}

//	 public Genre getGenre(){
//	 return genre;
//	 }
//	
//	public void setGenre(Genre genre) {
//		this.genre = genre;
//	}

	public void setGenreString(String genre) {
		this.genreString = genre;
	}
	
	public String getGenreString(){
		return this.genreString;
	}

	 public Publisher getPublisher() {
	 return publisher;
	 }

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String save() {
		// Alle Genre die hinzugefügt werden, werden hier in einem Set gelegt
		Set<Genre> genres = new HashSet<Genre>(makeStringToGenre());

		// Prüft ob Spiel schon in Datenbank
		this.game = mergeGame();
		game.setPublisher(mergePublisher());

		// Fügt Genre zu den Genre von Game hinzu, falls sie schon existieren
		game.setGenres(manager.addGenresToGame(genres, game));

		// Speicher/Merged das Spiel
		manager.saveGame(game);

		// Geht auf die GameListe Seite zurück
		return Pages.LIST_GAMES;
	}

	public String cancel() {
		return Pages.LIST_GAMES;
	}

	private Set<Genre> makeStringToGenre() {
		Set<Genre> genres = new HashSet<Genre>();
		int lastSpace = 0;
		
		for (int i = 0; i < genreString.length(); i++) {
			if(genreString.charAt(i) == ' '){
				Genre genre = new Genre();
				genre.setName(genreString.substring(lastSpace,i));
				genres.add(mergeGenre(genre));
				lastSpace = i+1;
			}
		}
		Genre genre = new Genre();
		genre.setName(genreString.substring(lastSpace, genreString.length()));
		genres.add(mergeGenre(genre));
		
		return genres;
	}

	/**
	 * Überprüft ob dieses Genre schon in der Datenbank existiert. Wenn es
	 * existiert dann wird das existierende Genre zurück gegeben
	 * 
	 * @return Genre
	 */
	private Genre mergeGenre(Genre genre) {
		for (Genre currentGenre : genres) {
			if (currentGenre.compareTo(genre) == 0) {
				return currentGenre;
			}
		}
		return genre;
	}

	/**
	 * Überprüft ob dieser Publisher schon in der Datenbank existiert. Wenn er
	 * existiert dann wird der existierende Publisher zurück gegeben
	 * 
	 * @return Publisher
	 */
	private Publisher mergePublisher() {
		// Iterate over the games so that we don't hit the DB again
		for (Game game : games) {
			Publisher publisher = game.getPublisher();
			if (publisher.compareTo(this.publisher) == 0) {
				return publisher;
			}
		}
		return this.publisher;
	}

	/**
	 * Überprüft ob das Spiel bereits in der Datenbank existiert. Wenn es
	 * existiert wird das bereits existierende Spiel zurück gegeben
	 * 
	 * @return Game
	 */
	private Game mergeGame() {
		for (Game game : games) {
			if (game.compareTo(this.game) == 0) {
				return game;
			}
		}
		return this.game;
	}
}