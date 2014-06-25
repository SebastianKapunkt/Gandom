package com.github.fhbjeeweb.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

/**
 * Transfer object for a Game Genre with an <tt>id</tt>,
 * a <tt>name</tt> and a list of games of this genre.<p>
 * </p>
 * There is a many-to-many relationship between Genre and Game.<p>
 * </p>
 * The following features are provided by the super class
 * <tt>BaseEntity</tt>:<p>
 * </p>
 * Transfer objects will be persisted.<p>
 * </p>
 * The <tt>name</tt> must not be <tt>null</tt>.<p>
 * </p>
 * Two Instances of Genre are considered equal if their names converted
 * to lowercase are equal.<p>
 * </p>
 * Instances of Genre are ordered using the natural ordering of their names
 * converted to lowercase.
 **/
@Entity
public class Genre extends BaseEntity {

    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<>();
    
    public Set<Game> getGames() {
    	return games;
    }
    
    public void setGames(Set<Game> games) {
    	this.games = games;
    }
}
