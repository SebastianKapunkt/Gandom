package com.github.gandom.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<T> implements Dao<T> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(final T t) {
        this.em.merge(t);
    }

    @Override
    public void update(final T t) {
        this.em.persist(this.em.merge(t));
    }

    @Override
    public void remove(final T t) {
    	//TODO implement it!
    }

    @Override
    public T findById(final Class<T> clazz, final Long id) {
        return this.em.find(clazz, id);
    }

    protected EntityManager getEm() {
        return em;
    }

    protected void setEm(EntityManager em) {
        this.em = em;
    }
}
