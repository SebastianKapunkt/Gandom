package com.github.fhbjeeweb.repository;

import com.github.fhbjeeweb.data.Genre;

import javax.persistence.TypedQuery;
import java.util.List;

public class GenreDao extends AbstractDao<Genre> {

    @Override
    public List<Genre> findAll() {

        final TypedQuery<Genre> query = getEm().createQuery(
                "Select a FROM " + Genre.class.getSimpleName() + " a",
                Genre.class);

        return query.getResultList();
    }
}
