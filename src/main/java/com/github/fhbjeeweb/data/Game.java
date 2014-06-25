package com.github.fhbjeeweb.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Transfer object for a game with an <tt>id</tt>, a <tt>name</tt>,
 * a <tt>publisher</tt> and a list of <tt>genres</tt> this game belongs to.</p>
 * <p>
 * There is a many-to-one relationship between Game and Publisher.</p>
 * <p>
 * There is a many-to-many relationship between Game and Genre.</p>
 * <p>
 * The following features are provided by the super class
 * <tt>BaseEntity</tt>:</p>
 * <p>
 * Transfer objects will be persisted.</p>
 * <p>
 * The <tt>name</tt> must not be <tt>null</tt>.</p>
 * <p>
 * Two Instances of Game are considered equal if their names converted
 * to lowercase are equal.</p>
 * <p>
 * Instances of Game are ordered using the natural ordering of their names
 * converted to lowercase.</p>
 */
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

    public Game() {}

    public Game(String name) {
        super(name);
    }

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
