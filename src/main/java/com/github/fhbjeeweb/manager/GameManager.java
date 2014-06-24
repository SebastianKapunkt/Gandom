/**
 * GameManager Interface
 *
 * Enthält alle wichtigen Funktionen die der GameManager braucht um die
 * GameCollection zu verarbeiten
 *
 */
package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.data.Genre;
import com.github.fhbjeeweb.data.Publisher;

import java.util.List;
import java.util.Set;

public interface GameManager {

    public void saveGame(final Game game);

    public void saveGenre(final Genre genre);

    public void savePublisher(final Publisher publisher);

    public List<Game> readGames();

    public List<Genre> readGenres();

    public List<Publisher> readPublishers();

    public Set<Genre> addGenreToGame(final Long[] genreIds, Game game);

    public Set<Genre> addGenresToGame(final Set<Genre> genres, Game game);

    public void removeGenreFromGame(final Long[] genreIds, Game game);

    public void removeGenreFromGame(Set<Genre> removeGenres, Game game);

    public void addPublisherToGame(final Long publisherId, final Game game);

    public void addPublisherToGame(final Publisher publisher, final Game game);

    public Publisher getPublisherById(final Long id);

    public Genre getGenreById(final Long id);

    public Game getGameById(final Long id);

    public Game getRandomGame(final List<Game> games);

    public void rename(Genre genre, final String name);

    public void rename(Game game, final String name);

    public void rename(Publisher publisher, final String name);
}
