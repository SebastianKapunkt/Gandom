package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.data.Genre;
import com.github.fhbjeeweb.data.Publisher;

import java.util.List;

public interface GameManager {

    public void saveGame(final Game game);

    public void saveGenre(final Genre genre);

    public void savePublisher(final Publisher publisher);

    public List<Game> readGames();

    public List<Genre> readGenres();

    public List<Publisher> readPublishers();

    public Publisher getPublisherById(final Long id);

    public Genre getGenreById(final Long id);

    public Game getGameById(final Long id);

	public Game selectRandomGame();

}
