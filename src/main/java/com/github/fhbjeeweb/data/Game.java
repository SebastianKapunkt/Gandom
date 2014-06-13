package com.github.fhbjeeweb.data;

public class Game {
    private String title;
    private String publisher;
    // TODO: Accept a list of genres per game
    private String genre;

    public Game(String title, String publisher, String genre) {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
    }

    public Game() {};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
