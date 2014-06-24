/**
 * Dao<T>
 *
 * ein Interface für standard Verwaltungsfunktionen wie
 * create, update, remove und find
 *
 */
package com.github.fhbjeeweb.repository;

import java.util.List;

/**
 * The Interface Dao.
 *
 * @param <T>
 *         the generic type
 */
public interface Dao<T> {

    /**
     * Creates a Object.
     *
     * @param t
     *         the t
     */
    public void create(final T t);

    /**
     * Update.
     *
     * @param t
     *         the t
     */
    public void update(final T t);

    /**
     * Removes a Object.
     *
     * @param t
     *         the t
     */
    public void remove(final T t);

    /**
     * Find all.
     *
     * @return the list< t>
     */
    public List<T> findAll();

    /**
     * Find by id.
     *
     * @param clazz
     *         the clazz
     * @param id
     *         the id
     * @return the t
     */
    public T findById(final Class<T> clazz, final Long id);
}
