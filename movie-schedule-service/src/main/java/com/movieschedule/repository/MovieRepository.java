package com.movieschedule.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieschedule.model.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies,Long>{

	List<Movies> findByTitle(String title);

	List<Movies> findByDate(LocalDate date);
	
}
