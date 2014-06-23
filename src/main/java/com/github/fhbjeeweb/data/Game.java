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

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Game extends BaseEntity implements Comparable<Game>{

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "game_genre",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private Set<Genre> genres = new HashSet<Genre>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @NotNull(message = "Bitte Name für Game eingeben")
    private String name;
    
    @Override
    public String toString() {
        return name.toString() + "(" + getId() + ")";
    }
    
    @Override
    public int compareTo(Game other) {
    	return String.CASE_INSENSITIVE_ORDER.compare(name,
                other.getName());
    }
    
    public Set<Genre> getGenres() {
    	return genres;
    }
    
    public void setGenres(Set<Genre> genres) {
    	this.genres = genres;
    }
    
    public Publisher getPublisher() {
    	return publisher;
    }
    
    public void setPublisher(Publisher publisher) {
    	this.publisher = publisher;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
}
