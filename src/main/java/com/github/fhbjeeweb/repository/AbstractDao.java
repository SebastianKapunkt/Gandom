/**
 * AbstractDao implementiert Dao
 *
 * Erzeugt eine Instanz vom EntityManager
 *
 */
package com.github.fhbjeeweb.repository;

import com.github.fhbjeeweb.data.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// TODO: Auto-generated Javadoc

/**
 * The Class AbstractDao.
 *
 * @param <T>
 *         the generic type
 */
public abstract class AbstractDao<T extends BaseEntity> implements Dao<T> {

    /**
     * Gets the em.
     *
     * @return the em
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Persistiert ein Objekt mit hilfe des EntityManager.
     *
     * @param t
     *         the t
     */
    @Override
    public void create(final T t) {
    	this.em.merge(t);
    }

    /**
     * Persistiret Änderungen an Objekten die schon in der Datenbank vorhanden
     * sind. Oder Persistiert noch nicht Vorhandene Objekte
     *
     * @param t
     *         the t
     */
    @Override
    public void update(final T t) {
    	this.em.persist(this.em.merge(t));
    }

    /**
     * Noch nicht Implementiert.
     *
     * @param t
     *         the t
     */
    @Override
    public void remove(final T t) {
        this.em.remove(this.em.find(t.getClass(), t.getId()));
    }

    /**
     * Es wird ein Objekt an hand seiner ID aus der Datenbank gesucht und zurück
     * gegeben.
     *
     * @param clazz
     *         the clazz
     * @param id
     *         the id
     * @return the t
     */
    @Override
    public T findById(final Class<T> clazz, final Long id) {
        return this.em.find(clazz, id);
    }

	/**
	 * @return the em
	 */
	protected EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	protected void setEm(EntityManager em) {
		this.em = em;
	}
}
