package com.moviebooking.model;

public class MovieCatalogue {
    private String title;
    private String description;
    private String genre;
    private float imdbRating;

    public MovieCatalogue() {}

    public MovieCatalogue(String title, String description, String genre, float imdbRating) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.imdbRating = imdbRating;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }
}
