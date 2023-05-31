package com.moviebooking.model;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "movie_schedule")
public class MovieSchedule {
    @Field("_id")
    private String movieId;
    private Date date;

    public MovieSchedule() {}

    public MovieSchedule(String movieId, Date date) {
        this.movieId = movieId;
        this.date = date;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }   
}
