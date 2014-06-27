package com.github.fhbjeeweb.repository;

import java.util.List;

public interface Dao<T> {

    public void create(final T t);

    public void update(final T t);

    public void remove(final T t);

    public List<T> findAll();

    public T findById(final Class<T> clazz, final Long id);
}
