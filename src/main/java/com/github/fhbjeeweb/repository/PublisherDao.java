/*
 * 
 */
package com.github.fhbjeeweb.repository;

import com.github.fhbjeeweb.data.Publisher;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The Class PublisherDao.
 */
public class PublisherDao extends AbstractDao<Publisher> {

    /**
     * Gibt eine Liste von Publisher-Objekten zurück
     * <p/>
     * unter Verwendung einer TypedQuery wird mit hilfe des Entity Manager eine
     * Anfrage an die Datenbank gestellt die den Inhalt der Tabelle Publisher
     * ausliest. Diese Tabelle wird dann in die TypedQuery geladen.
     *
     * @return the list< publisher>
     */
    @Override
    public List<Publisher> findAll() {

        final TypedQuery<Publisher> query = getEm().createQuery(
                "Select a FROM " + Publisher.class.getSimpleName() + " a",
                Publisher.class);

        return query.getResultList();

    }

}
