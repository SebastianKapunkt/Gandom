package com.github.fhbjeeweb.repository;

import com.github.fhbjeeweb.data.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import java.util.List;

@Named(value = "publisherDao")
@ApplicationScoped
public class PublisherDao extends AbstractDao<Publisher> {

    @Override
    public List<Publisher> findAll() {

        final TypedQuery<Publisher> query = getEm().createQuery(
                "Select a FROM " + Publisher.class.getSimpleName() + " a",
                Publisher.class);

        return query.getResultList();
    }
}
