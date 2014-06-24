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

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * The Class GameManagerBo.
 */
@Stateless
@Named(value = "manager1")
public class GameManagerBo implements Serializable, GameManager {

    /**
     *
     */
    private static final long serialVersionUID = -7645272616890051722L;

    /** game dao. */
    @Inject
    private Dao<Game> gameDao;

    /** genre dao. */
    @Inject
    private Dao<Genre> genreDao;

    /** publisher dao. */
    @Inject
    private Dao<Publisher> publisherDao;

    /**
     * Gibt die Daten an den gameDao weiter. Wenn das Objekt mit einer Id
     * übergeben wird, wird davon ausgegangen, dass das Objekt bereits in der
     * Datenbank existiert. Also wird die Methode Update aufgerufen um die Daten
     * zu Aktualisieren. Wenn keine Id vorhanden ist, wird davon ausgegangen,
     * dass das Objekt nocht nicht in der Datenbank existiert und somit über
     * create erzeugt.
     *
     * @param Game
     */
    @Override
    public void saveGame(Game game) {
        if (game.getId() == null) {
            this.gameDao.create(game);
        } else {
            this.gameDao.update(game);
        }
    }

    /**
     * Gibt die Daten an den genreDao weiter. Wenn das Objekt mit einer Id
     * übergeben wird, wird davon ausgegangen, dass das Objekt bereits in der
     * Datenbank existiert. Also wird die Methode Update aufgerufen um die Daten
     * zu Aktualisieren. Wenn keine Id vorhanden ist, wird davon ausgegangen,
     * dass das Objekt nocht nicht in der Datenbank existiert und somit über
     * create erzeugt.
     *
     * @param Genre
     */
    @Override
    public void saveGenre(Genre genre) {
        if (genre.getId() == null) {
            this.genreDao.create(genre);
        } else {
            this.genreDao.update(genre);
        }
    }

    /**
     * Gibt die Daten an den publisherDao weiter. Wenn das Objekt mit einer Id
     * übergeben wird, wird davon ausgegangen, dass das Objekt bereits in der
     * Datenbank existiert. Also wird die Methode Update aufgerufen um die Daten
     * zu Aktualisieren. Wenn keine Id vorhanden ist, wird davon ausgegangen,
     * dass das Objekt nocht nicht in der Datenbank existiert und somit über
     * create erzeugt.
     *
     * @param Pubisher
     */
    @Override
    public void savePublisher(Publisher publisher) {
        if (publisher.getId() == null) {
            this.publisherDao.create(publisher);
        } else {
            this.publisherDao.update(publisher);
        }
    }

    /**
     * Gibt eine Liste von Allen Spielen zurück, die in der Datenbank sind.
     * Dafür wird im gameDao die Methode findAll() aufgerufen.
     *
     * @return List<Game>
     */
    @Override
    public List<Game> readGames() {
        return this.gameDao.findAll();
    }

    /**
     * Gibt eine Liste von Allen Spielen zurück, die in der Datenbank sind.
     * Dafür wird im genreDao die Methode findAll() aufgerufen.
     *
     * @return List<Genre>
     */
    @Override
    public List<Genre> readGenres() {
        return this.genreDao.findAll();
    }

    /**
     * Gibt eine Liste von Allen Spielen zurück, die in der Datenbank sind.
     * Dafür wird im publisherDao die Methode findAll() aufgerufen.
     *
     * @return List<Publisher>
     */
    @Override
    public List<Publisher> readPublishers() {
        return this.publisherDao.findAll();
    }

    /**
     * Sucht mit hilfe der Id einen Publisher. Der Publisher und das Game werden
     * dann an addPublisherToGame(Publisher publisher, Game game) überreicht.
     *
     * @param Long
     *         []
     * @param Game
     */
    @Override
    public void addPublisherToGame(final Long publisherId, final Game game) {
        final Publisher publisher = getPublisherById(publisherId);
        addPublisherToGame(publisher, game);
    }

    /**
     * Fügt dem Game einen Publisher hinzu.
     *
     * @param Publisher
     * @param Game
     */
    @Override
    public void addPublisherToGame(final Publisher publisher, final Game game) {
        game.setPublisher(publisher);
        saveGame(game);
    }

    /**
     * Erzeugt aus einer Liste von Id´s eine Liste von Genre. Übergibt dann die
     * Liste mit den Genre und das Game an addGenreToGame(Set Genre, Game
     * game).
     *
     * @param Long
     *         []
     * @param Game
     * @return 
     */
    @Override
    public Set<Genre> addGenreToGame(final Long[] genreIds, final Game game) {
        Set<Genre> gameGenres = new HashSet<Genre>();

        // Aus der Liste von IDs wird nun für jede ID das entsprechende Obejtk
        // aus der Datenbank gesucht
        for (Long genreId : genreIds) {
            Genre genre = getGenreById(genreId);
            gameGenres.add(genre);
        }
        return addGenresToGame(gameGenres, game);
    }

    /**
     * Fügt alle Genre der Liste genres zum Game hinzu.
     *
     * @param Set
     *         <Genre>
     * @param Game
     */
    @Override
    public Set<Genre> addGenresToGame(final Set<Genre> genres, Game game) {
        Set<Genre> gameGenres = game.getGenres();
        Boolean alreadyIn = false;

        // Für den Fall das in der genres Liste keine Objekte enhalten sind
        if (gameGenres == null) {
            gameGenres = new HashSet<Genre>();
        }

        // Für jedes Objekt in genres wir nun überprüft ob dieses schon in der
        // Liste vom Game ist
        for (Genre genre : genres) {
            for (Genre genre2 : gameGenres) {
                if (genre.getName().equals(genre2.getName())) {
                    alreadyIn = true;
                }
            }
            if (!alreadyIn) {
                gameGenres.add(genre);
            }
            alreadyIn = false;
        }

        return gameGenres;
    }

    /**
     * Wandelt die Liste der Id´s in ein Set von Genre um. Übergibt dieses Set
     * dann an removeGenreFromGame(Set<Genre> removeGenres, Game game) mit dem
     * Spiel.
     *
     * @param Long
     *         []
     * @param Game
     */
    @Override
    public void removeGenreFromGame(Long[] genreIds, Game game) {
        Set<Genre> removeGenres = new HashSet<Genre>();
        for (Long genreId : genreIds) {
            Genre genre = getGenreById(genreId);
            removeGenres.add(genre);
        }
        removeGenreFromGame(removeGenres, game);
    }

    /**
     * Löscht alle Genre, die an die Methode übergeben werden.
     *
     * @param Set
     *         <Genre>
     * @param Game
     */
    @Override
    public void removeGenreFromGame(Set<Genre> removeGenres, Game game) {
        Set<Genre> gameGenres = game.getGenres();
        Set<Genre> oldGenres = new HashSet<Genre>();
        boolean in = false;

        for (Genre genre : gameGenres) {
            for (Genre removeGenre : removeGenres) {
                if (genre.getId() == removeGenre.getId()) {
                    in = true;
                }
            }
            if (!in) {
                oldGenres.add(genre);
            }
            in = false;
        }

        game.setGenres(oldGenres);
        saveGame(game);
    }

    /**
     * Sucht ein Genre anhand einer ID aus der Datenbank. Wenn kein Eintrag
     * vorhanden ist dann wird ein neues Objekt erzeugt.
     *
     * @param Long
     * @return Genre
     */
    @Override
    public Genre getGenreById(Long id) {
        Genre genre = this.genreDao.findById(Genre.class, id);

        if (genre == null) {
            genre = new Genre();
        }

        return genre;
    }

    /**
     * Sucht ein Publisher anhand einer ID aus der Datenbank. Wenn kein Eintrag
     * vorhanden ist dann wird ein neues Objekt erzeugt.
     *
     * @param Long
     * @return Publisher
     */
    @Override
    public Publisher getPublisherById(Long id) {
        Publisher publisher = this.publisherDao.findById(Publisher.class, id);

        if (publisher == null) {
            publisher = new Publisher();
        }

        return publisher;
    }

    /**
     * Sucht ein Game anhand einer ID aus der Datenbank. Wenn kein Eintrag
     * vorhanden ist dann wird ein neues Objekt erzeugt.
     *
     * @param Long
     * @return Game
     */
    @Override
    public Game getGameById(Long id) {
        Game game = gameDao.findById(Game.class, id);

        if (game == null) {
            game = new Game();
        }

        return game;
    }

    /**
     * Sucht zufüllig ein Game aus einer Liste Games heraus. Wenn die Liste leer
     * ist wird ein neues Objekt erzeugt.
     *
     * @param List
     *         <Game>
     * @return Game
     */
    @Override
    public Game getRandomGame(List<Game> games) {
        // wenn die Liste nicht leer ist
        if (games != null) {
            // Instanz von Random erzeugen
            Random rnd = new Random();
            // erzeugen der Position des Zufällig auszuwählenden Objekts
            int position = rnd.nextInt(games.size()) + 1;
            // gibt das entsprechende Objekt an der Position nun zurück
            return games.get(position - 1);
        }
        return new Game();
    }

    @Override
    public void rename(Genre genre, final String name) {
        genre.setName(name);
        saveGenre(genre);
    }

    @Override
    public void rename(Game game, final String name) {
        game.setName(name);
        saveGame(game);
    }

    @Override
    public void rename(Publisher publisher, final String name) {
        publisher.setName(name);
        savePublisher(publisher);
    }
}
