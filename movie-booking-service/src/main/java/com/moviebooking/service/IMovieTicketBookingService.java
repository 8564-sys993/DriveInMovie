package com.moviebooking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.moviebooking.exception.ParkingSlotAlreadyBookedException;
import com.moviebooking.exception.ParkingSlotDoesNotHaveThisMovieException;
import com.moviebooking.exception.ParkingSlotNotFoundException;
import com.moviebooking.exception.TicketNotFoundException;
import com.moviebooking.model.MovieTicket;
import com.moviebooking.model.ParkingSlot;

public interface IMovieTicketBookingService {
	List<ParkingSlot> getAvailableParkingSlots(String movieTitle, LocalDate movieDate, LocalTime movieTime) throws ParkingSlotDoesNotHaveThisMovieException;
	
	MovieTicket bookTicket(String carNumber, String movieTitle, int slotNumber, LocalDate date, LocalTime time) throws ParkingSlotNotFoundException, ParkingSlotAlreadyBookedException, ParkingSlotDoesNotHaveThisMovieException;
	
	void cancelBooking(String ticketId) throws TicketNotFoundException;

	List<Object> viewBookingDetails(String ticketId) throws TicketNotFoundException;
}
