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

    @Inject
    private Dao<Game> gameDao;

    @Inject
    private Dao<Genre> genreDao;

    @Inject
    private Dao<Publisher> publisherDao;

    @Override
    public void editGame(Game game) {

        lookupGameId(game);
        lookupPublisherId(game);
        lookupGenreIds(game);

        gameDao.update(game);
    }

    @Override
    public void addGame(Game game) {
        // Do nothing if the game already exists
        // TODO: Should we throw an Exception instead?
        if (lookupGameId(game).getId() == null) {
            lookupPublisherId(game);
            lookupGenreIds(game);
            gameDao.create(game);
        }
    }

    @Override
    public void saveGenre(Genre genre) {
        if (genre.getId() == null) {
            genreDao.create(genre);
        } else {
            genreDao.update(genre);
        }
    }

    @Override
    public void savePublisher(Publisher publisher) {
        if (publisher.getId() == null) {
            publisherDao.create(publisher);
        } else {
            publisherDao.update(publisher);
        }
    }

    @Override
    public List<Game> readGames() {
        return gameDao.findAll();
    }

    @Override
    public List<Genre> readGenres() {
        return genreDao.findAll();
    }

    @Override
    public List<Publisher> readPublishers() {
        return publisherDao.findAll();
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreDao.findById(Genre.class, id);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherDao.findById(Publisher.class, id);
    }

    @Override
    public Game getGameById(Long id) {
        return gameDao.findById(Game.class, id);
    }

    @Override
    // TODO: Make sure this is only called when there is at least one Game
    public Game selectRandomGame() {
        List<Game> games = readGames();

        if (games == null)
            throw new IllegalStateException("The game list is empty");

        int randomIndex = new Random().nextInt(games.size());
        return games.get(randomIndex);
    }

    private Game lookupGameId(Game game) {
        List<Game> games = readGames();

        for (Game persistedGame : games) {
            if (persistedGame.equals(game)) {
                game.setId(persistedGame.getId());
                return game;
            }
        }

        // The game has not yet been persisted and the id is still null
        // Hibernate will add an id later
        return game;
    }

    private Game lookupPublisherId(Game game) {
        List<Publisher> publishers = readPublishers();

        for (Publisher persistedPublisher : publishers) {
            if (persistedPublisher.equals(game.getPublisher())) {
                game.getPublisher().setId(persistedPublisher.getId());
                return game;
            }
        }

        // The publisher has not yet been persisted and the id is still null
        // Hibernate will add an id later
        return game;
    }

    private Game lookupGenreIds(Game game) {
        List<Genre> genres = readGenres();

        for (Genre persistedGenre : genres) {
            for (Genre genre : game.getGenres()) {
                if (persistedGenre.equals(genre)) {
                    genre.setId(persistedGenre.getId());
                }

            }
            // The genre has not yet been persisted and the id is still null
            // Hibernate will add an id later
        }

        return game;
    }
}
