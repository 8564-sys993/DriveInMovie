package com.moviebooking.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.model.MovieTicket;

@Repository
public interface MovieTicketRepository extends MongoRepository<MovieTicket, String> {
	
	MovieTicket findByMovieTitle(String movieTitle);
	
}

