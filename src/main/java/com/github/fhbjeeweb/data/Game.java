/**
 * Game erbt von BaseEntity
 *
 * besitzt eine Many to Many Beziehung zu Genre
 * und eine Many to One Beziehung zu Publisher
 *
 * der Name darf nicht null sein
 *
 *
 * Diese Klassen soll ein Spiel wiederspiegeln. Zu diesem Spielt gibt es
 * belibig viele Genre und genau einen Publisher.
 *
 * */
package com.github.fhbjeeweb.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Game extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "game_genre",
            joinColumns = { @JoinColumn(name = "game_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") })
    private Set<Genre> genres = new HashSet<>();

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Genre> getGenres() {
    	return genres;
    }
    
    public void setGenres(Set<Genre> genres) {
    	this.genres = genres;
    }
}
