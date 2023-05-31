package com.moviebooking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moviebooking.exception.ParkingSlotAlreadyBookedException;
import com.moviebooking.exception.ParkingSlotDoesNotHaveThisMovieException;
import com.moviebooking.exception.ParkingSlotNotFoundException;
import com.moviebooking.exception.TicketNotFoundException;
import com.moviebooking.model.MovieCatalogue;
import com.moviebooking.model.MovieTicket;
import com.moviebooking.model.Movies;
import com.moviebooking.model.MoviesList;
import com.moviebooking.model.ParkingSlot;
import com.moviebooking.repository.MovieTicketRepository;
import com.moviebooking.repository.ParkingSlotRepository;

@Service
public class MovieTicketBookingServiceImpl implements IMovieTicketBookingService{

	@Autowired
	private MovieTicketRepository movieTicketRepository;

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<ParkingSlot> getAvailableParkingSlots(String movieTitle, LocalDate movieDate, LocalTime movieTime)
			throws ParkingSlotDoesNotHaveThisMovieException {

		//MoviesList moviesList = restTemplate.getForObject("http://movie-schedule-service/schedule/bydate/" + movieDate, MoviesList.class);
		MoviesList moviesList = restTemplate.getForObject("http://localhost:8082/schedule/bydate/" + movieDate, MoviesList.class);

		List<Movies> movies = moviesList.getAllMovies();
		
		List<String> allMovieTitles = new ArrayList<>();
		
		for(Movies movie : movies) {
			allMovieTitles.add(movie.getTitle());
		}

		if (allMovieTitles.contains(movieTitle)) {
			List<ParkingSlot> availableSlots = parkingSlotRepository.findByAvailable(true);
			return availableSlots;
		} else {
			throw new ParkingSlotDoesNotHaveThisMovieException(movieTitle + " not available for date " + movieDate);
		}
	}

	public MovieTicket bookTicket(String carNumber, String movieTitle, int slotNumber, LocalDate date,
			LocalTime time) throws ParkingSlotNotFoundException, ParkingSlotAlreadyBookedException,
			ParkingSlotDoesNotHaveThisMovieException {
		MovieTicket ticket = null;

		ParkingSlot parkingSlot = parkingSlotRepository.findBySlotNumber(slotNumber).orElseThrow(
				() -> new ParkingSlotNotFoundException("Parking slot number " + slotNumber + " not found"));

		if (parkingSlot != null && parkingSlot.isAvailable())  {
			parkingSlot.setAvailable(false);
			ticket = new MovieTicket(carNumber, movieTitle, slotNumber, "Booked", date, time);
			parkingSlotRepository.save(parkingSlot);
			movieTicketRepository.save(ticket);
		} else {
			throw new ParkingSlotAlreadyBookedException(
					"Parking slot number " + slotNumber + " is already booked");
		}

		return ticket;

	}

	public void cancelBooking(String ticketId) throws TicketNotFoundException {

		MovieTicket ticket = movieTicketRepository.findById(ticketId)
				.orElseThrow(() -> new TicketNotFoundException("Ticket with ID " + ticketId + " not found"));
		ticket.setStatus("Cancelled");
		int slotNumber = ticket.getSlotNumber();
		Optional<ParkingSlot> parkingSlot = parkingSlotRepository.findBySlotNumber(slotNumber);
		if (parkingSlot.isPresent()) {
			parkingSlot.get().setAvailable(true);
		}
		parkingSlotRepository.save(parkingSlot.get());
		movieTicketRepository.save(ticket);
	}

	public List<Object> viewBookingDetails(String ticketId) throws TicketNotFoundException {

		List<Object> list = new ArrayList<>();
		MovieTicket ticket = movieTicketRepository.findById(ticketId)
				.orElseThrow(() -> new TicketNotFoundException("Ticket with ID " + ticketId + " not found"));

//		MovieCatalogue movieCatalogue = restTemplate.getForObject("http://movie-catalogue-service/movie/" + ticket.getMovieTitle(),
//				MovieCatalogue.class);
		MovieCatalogue movieCatalogue = restTemplate.getForObject("http://localhost:8081/movie/" + ticket.getMovieTitle(),
				MovieCatalogue.class);

		list.add(ticket);
		list.add(movieCatalogue);
		return list;
	}
}
