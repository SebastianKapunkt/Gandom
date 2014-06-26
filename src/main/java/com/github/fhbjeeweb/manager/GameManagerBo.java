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
    @Inject // TODO: Daos are not yet annotated for CDI
    private Dao<Game> gameDao;

    @Inject // TODO: Daos are not yet annotated for CDI
    private Dao<Genre> genreDao;

    @Inject // TODO: Daos are not yet annotated for CDI
    private Dao<Publisher> publisherDao;

    @Override
    public void saveGame(Game game) {
        
    	if (!game.getIsEdited()) {
        	addGameId(game);
        	addPublisherId(game);
        	addGenresIds(game);
        	mergeGenres(game);
		}else{
        	addPublisherId(game);
        	addGenresIds(game);
		}

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

    private Game addGameId(Game game){
        List<Game> games = readGames();

        for (Game persistedGame : games ) {
            if (persistedGame.equals(game)) {
                game.setId(persistedGame.getId());
                return game;
            }
        }

        // The game has not yet been persisted and the id is still null
        // Hibernate will add an id later
        return game;
    }
    private Game addPublisherId(Game game){
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

    private Game addGenresIds(Game game){
        List<Genre> genres = readGenres();

        for (Genre persistedGenre : genres) {
            for (Genre genre : game.getGenres()){
                if(persistedGenre.equals(genre)){
                    genre.setId(persistedGenre.getId());
                }
            }
        }

        // The publisher has not yet been persisted and the id is still null
        // Hibernate will add an id later
        return game;
    }

    private Game mergeGenres(Game game) {
        if (game.getId() != null) {
            Game persistedGame = getGameById(game.getId());
            game.getGenres().addAll(persistedGame.getGenres());
        }

        return game;
    }
}
