package com.movieschedule.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieschedule.model.Movies;
import com.movieschedule.model.MoviesList;
import com.movieschedule.repository.MovieRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	 
//	    public MovieService(MovieRepository movieRepository) {
//	        this.movieRepository = movieRepository;
//	    }

    public  MoviesList getAllMovies() {
    	List<Movies> list =  movieRepository.findAll();
    	MoviesList moviesList = new MoviesList(list);
        return moviesList;
    }

    public Movies addMovie(Movies movie) {
        return movieRepository.save(movie);
    }
//
    public Movies updateMovie(Long id, Movies updatedMovie) {
        Movies movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            throw new EntityNotFoundException("Movie not found with ID " + id);
        }
        movie.setTitle(updatedMovie.getTitle());
        movie.setDate(updatedMovie.getDate());
        movie.setTime(updatedMovie.getTime());
        return movieRepository.save(movie);
    }
//
    public void deleteMovie(Long id) {
        Movies movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            throw new EntityNotFoundException("Movie not found with ID " + id);
        }
        movieRepository.delete(movie);
    }
//
    public List<Movies> getMoviesByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movies> getMoviesByDate(LocalDate date) {
        return movieRepository.findByDate(date);
    }

}

