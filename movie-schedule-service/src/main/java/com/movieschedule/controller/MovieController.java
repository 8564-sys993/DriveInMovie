package com.movieschedule.controller;

import java.time.LocalDate;
//import java.sql.Date;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieschedule.model.Movies;
import com.movieschedule.model.MoviesList;
import com.movieschedule.service.MovieService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/schedule")
public class MovieController {
	@Autowired
	private MovieService repo; // service

//	private List<Movies> movies = new ArrayList<>();

	@GetMapping("/all")
	public MoviesList getAllMovies() {
		return repo.getAllMovies();
	}

//	@GetMapping("/get")
//	public ResponseEntity<List<Movies>> getAllMovies() {
//	    List<Movies> movies = repo.getAllMovies();
//	    if (movies.isEmpty()) {
//	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    }
//	    return new ResponseEntity<>(movies, HttpStatus.OK);
//	}

	@PostMapping("/create")
	public Movies addMovies(@RequestBody Movies movie) {
		return repo.addMovie(movie);
	}

	@PutMapping("/update/{id}")
	public Movies updateMovies(@PathVariable Long id, @RequestBody Movies updatedMovie) {
		Movies movie = repo.updateMovie(id, updatedMovie);
		if (movie == null) {
			throw new EntityNotFoundException("Movie not found with ID " + id);
		}
		movie.setTitle(updatedMovie.getTitle());

		movie.setDate(updatedMovie.getDate());
		movie.setTime(updatedMovie.getTime());
		return movie;
	}

//	 @DeleteMapping("/delete/{id}")
//	 public void deleteMovies(@PathVariable Long id) {
//	     repo.deleteMovie(id);
//	     if (movie == null) {
//	         throw new EntityNotFoundException("Movie not found with ID " + id);
//	     }
//	     repo.delete(movie);

	@DeleteMapping("/delete/{id}")
	public void deleteMovies(@PathVariable Long id) {
		repo.deleteMovie(id);
	}

//	 @GetMapping("/byname/{name}")
//	 public List<Movies> getMoviesByName(@PathVariable String name) {
//	     return repo.findByTitle(name);
//	 }

	@GetMapping("/byname/{name}")
	public List<Movies> getMoviesByName(@PathVariable String name) {
		return repo.getMoviesByTitle(name);
	}

//	        
//	 @GetMapping("/bydate/{date}")
//	 public List<Movies> getMoviesByDate(@PathVariable Date date) {
//	     return repo.findByDate(date);
//	 }

	@GetMapping("/bydate/{date}")
	public MoviesList getMoviesByDate(@PathVariable LocalDate date) {
		MoviesList list = new MoviesList();
		list.setAllMovies(repo.getMoviesByDate(date));
		return list;

	}

}
