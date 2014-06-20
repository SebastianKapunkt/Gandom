package com.github.fhbjeeweb.data;

public class Game implements Comparable<Game> {
    private String title;
    private String publisher;
    // TODO: Accept a list of genres per game
    // The String genres is currently expected to hold one or more Genres
    // seperated by commas
    private String genres;

    public Game(String title, String publisher, String genres) {
        this.title = title;
        this.publisher = publisher;
        this.genres = genres;
    }

    public Game() {}

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

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;

        Game game = (Game) o;

        if (genres != null ? !genres.equals(game.genres) : game.genres != null) {
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
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
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

    @Override
    public int compareTo(Game other) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.toString(),
                other.toString());
    }
}
