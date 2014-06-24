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

import java.util.HashSet;
import java.util.Set;

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
