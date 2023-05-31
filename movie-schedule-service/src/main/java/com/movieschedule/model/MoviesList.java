package com.movieschedule.model;

import java.util.List;

public class MoviesList {

	private List<Movies> allMovies;

	public MoviesList() {
    }


	public MoviesList(List<Movies> allMovies) {
    super();
    this.allMovies = allMovies;
    }

	public List<Movies> getAllMovies() {
    return allMovies; 
    }

	public void setAllMovies(List<Movies> allMovies) {
    this.allMovies = allMovies;
    }

}
