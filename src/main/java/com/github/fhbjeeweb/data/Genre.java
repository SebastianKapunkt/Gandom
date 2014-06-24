/**
 * Genre erbt von BaseEntity
 *
 * besitzt eine Many to Many Beziehung zu Game
 *
 * der Name dar nicht null sein
 *
 * Die Klasse soll ein Genre wiederspiegeln. Zu jedem Genre gibt es belibig
 * viele Spiele.
 *
 */

package com.github.fhbjeeweb.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre extends BaseEntity implements Comparable<Genre> {

	@NotNull(message = "Bitte Name für Genre eingeben")
    private String name;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<Game>();
    
    @Override
    public String toString() {
        return name.toString() + "(" + getId() + ")";
    }
    
    @Override
    public int compareTo(Genre other) {
    	return String.CASE_INSENSITIVE_ORDER.compare(name,
                other.getName());
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public Set<Game> getGames() {
    	return games;
    }
    
    public void setGames(Set<Game> games) {
    	this.games = games;
    }
}
