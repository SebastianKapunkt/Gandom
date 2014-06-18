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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;

        Game game = (Game) o;

        if (genre != null ? !genre.equals(game.genre) : game.genre != null) {
            return false;
        }
        if (!publisher.equals(game.publisher)) return false;
        if (!title.equals(game.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Game{");
        sb.append("title='").append(title).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
