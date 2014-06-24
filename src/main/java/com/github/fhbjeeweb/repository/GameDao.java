/**
 * GameDao erbt von AbstractDao
 *
 * implementiert die finAll() Funktion vom Dao
 *
 */
package com.github.fhbjeeweb.repository;

import com.github.fhbjeeweb.data.Game;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The Class GameDao.
 */
public class GameDao extends AbstractDao<Game> {

    /**
     * Gibt eine Liste von Game-Objekten zurück
     * <p/>
     * unter Verwendung einer TypedQuery wird mit hilfe des Entity Manager eine
     * Anfrage an die Datenbank gestellt die den Inhalt der Tabelle Game
     * ausliest. Diese Tabelle wird dann in die TypedQuery geladen.
     *
     * @return the list< game>
     */
    @Override
    public List<Game> findAll() {

        final TypedQuery<Game> query = getEm().createQuery(
                "Select a FROM " + Game.class.getSimpleName() + " a",
                Game.class);

        return query.getResultList();

    }

}
