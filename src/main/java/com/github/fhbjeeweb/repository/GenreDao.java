/*
 * 
 */
package com.github.fhbjeeweb.repository;

import com.github.fhbjeeweb.data.Genre;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The Class GenreDao.
 */
public class GenreDao extends AbstractDao<Genre> {

    /**
     * Gibt eine Liste von Genre-Objekten zurück
     * <p/>
     * unter Verwendung einer TypedQuery wird mit hilfe des Entity Manager eine
     * Anfrage an die Datenbank gestellt die den Inhalt der Tabelle Genre
     * ausliest. Diese Tabelle wird dann in die TypedQuery geladen.
     *
     * @return the list< genre>
     */
    @Override
    public List<Genre> findAll() {

        final TypedQuery<Genre> query = getEm().createQuery(
                "Select a FROM " + Genre.class.getSimpleName() + " a",
                Genre.class);

        return query.getResultList();

    }

}
