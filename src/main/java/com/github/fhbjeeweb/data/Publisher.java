package com.github.fhbjeeweb.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

/**
 * Transfer object for a Game Publisher with an <tt>id</tt>,
 * a <tt>name</tt> and a list of published games.<p>
 * </p>
 * There is a one-to-many relationship between Publisher and Game.<p>
 * </p>
 * The following features are provided by the super class
 * <tt>BaseEntity</tt>:<p>
 * </p>
 * Transfer objects will be persisted.<p>
 * </p>
 * The <tt>name</tt> must not be <tt>null</tt>.<p>
 * </p>
 * Two Instances of Publisher are considered equal if their names converted
 * to lowercase are equal.<p>
 * </p>
 * Instances of Publisher are ordered using the natural ordering of their names
 * converted to lowercase.
 **/
@Entity
public class Publisher extends BaseEntity {

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<>();
    
    public Set<Game> getGames() {
    	return games;
    }
    
    public void setGames(Set<Game> games) {
    	this.games = games;
    }
}
