package com.github.fhbjeeweb.repository;

import com.github.fhbjeeweb.data.Game;

import javax.persistence.TypedQuery;
import java.util.List;

public class GameDao extends AbstractDao<Game> {

    @Override
    public List<Game> findAll() {

        final TypedQuery<Game> query = getEm().createQuery(
                "Select a FROM " + Game.class.getSimpleName() + " a",
                Game.class);

        return query.getResultList();
    }
}
