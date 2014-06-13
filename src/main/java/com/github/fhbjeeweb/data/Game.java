package com.github.fhbjeeweb.data;

public class Game {
    private String name;
    private String publisher;
    // TODO: Accept a list of genres per game
    private String genre;

    public Game(String name, String publisher, String genre) {
        this.name = name;
        this.publisher = publisher;
        this.genre = genre;
    }

    public Game() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
