/**
 * Publisher erbt von BaseEntity
 *
 * besitzt eine One to Many Beziehung zu Game
 *
 * der Name dar nicht null sein
 *
 *
 * Diese Klasse soll ein Publisher wiederspiegeln. Jeder Publisher hat
 * belibig viele Spiele
 */
package com.github.fhbjeeweb.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher extends BaseEntity implements Comparable<Publisher> {

	@NotNull(message = "Bitte Name für Publisher eingeben")
    private String name;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<Game>();
    
    @Override
    public String toString() {
        return name.toString() + "(" + getId() + ")";
    }
    
    @Override
    public int compareTo(Publisher other) {
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
