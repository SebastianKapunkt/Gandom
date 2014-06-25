/**
 * GameMangerBo implementiert den GameManager
 *
 * Ist das BusinessObjekt --> Unser Manager
 *
 */
package com.github.fhbjeeweb.manager;

import com.github.fhbjeeweb.data.Game;
import com.github.fhbjeeweb.data.Genre;
import com.github.fhbjeeweb.data.Publisher;
import com.github.fhbjeeweb.repository.Dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;
import java.util.Random;

@Stateless
@Named(value = "manager")
public class GameManagerBo implements GameManager {
    @Inject // FIXME: Daos are not yet annotated for CDI
    private Dao<Game> gameDao;

    @Inject // FIXME: Daos are not yet annotated for CDI
    private Dao<Genre> genreDao;

    @Inject // FIXME: Daos are not yet annotated for CDI
    private Dao<Publisher> publisherDao;

    @Override
    public void saveGame(Game game) {
        if (game.getId() == null) {
            this.gameDao.create(game);
        } else {
            this.gameDao.update(game);
        }
    }

    @Override
    public List<Game> readGames() {
        return this.gameDao.findAll();
    }

    @Override
    public List<Genre> readGenres() {
        return this.genreDao.findAll();
    }

    @Override
    public List<Publisher> readPublishers() {
        return this.publisherDao.findAll();
    }

    @Override
    public Genre getGenreById(Long id) {
        Genre genre = this.genreDao.findById(Genre.class, id);

        // FIXME: Throw an Exception instead
        if (genre == null) {
            genre = new Genre();
        }

        return genre;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        Publisher publisher = this.publisherDao.findById(Publisher.class, id);

        // FIXME: Throw an Exception instead
        if (publisher == null) {
            publisher = new Publisher();
        }

        return publisher;
    }

    @Override
    public Game getGameById(Long id) {
        Game game = gameDao.findById(Game.class, id);

        // FIXME: Throw an Exception instead
        if (game == null) {
            game = new Game();
        }

        return game;
    }

    @Override
    // TODO: Make sure this is only called when there is at least one Game
    // TODO: Maybe pass in a game list to avoid hitting the database
    public Game selectRandomGame() {
        List<Game> games = readGames();

        if (games == null) throw new IllegalStateException(
                "The game list is empty");

        int randomIndex = new Random().nextInt(games.size());
        return games.get(randomIndex);
    }
}
