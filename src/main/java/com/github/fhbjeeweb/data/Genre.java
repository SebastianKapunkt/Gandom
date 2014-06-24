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

import java.util.HashSet;
import java.util.Set;

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
