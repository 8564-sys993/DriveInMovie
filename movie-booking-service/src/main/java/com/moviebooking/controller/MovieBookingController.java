package com.moviebooking.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.exception.ParkingSlotAlreadyBookedException;
import com.moviebooking.exception.ParkingSlotDoesNotHaveThisMovieException;
import com.moviebooking.exception.ParkingSlotNotFoundException;
import com.moviebooking.exception.TicketNotFoundException;
import com.moviebooking.model.MovieTicket;
import com.moviebooking.model.ParkingSlot;
import com.moviebooking.service.IMovieTicketBookingService;

@RestController
@RequestMapping("/booking")
public class MovieBookingController {
	
	@Autowired
	private IMovieTicketBookingService movieTicketService;

	@GetMapping("/view-slot-availaibility")
	public List<ParkingSlot> bookMovie(@RequestParam String movieTitle, @RequestParam LocalDate movieDate ,@RequestParam LocalTime movieTime) throws ParkingSlotDoesNotHaveThisMovieException {
		return movieTicketService.getAvailableParkingSlots(movieTitle, movieDate, movieTime);
	}
	
	@PostMapping("/book")
    public MovieTicket bookTicket(@RequestParam String carNumber,@RequestParam String movieTitle,@RequestParam  int slotNumber, @RequestParam LocalDate date,
    		@RequestParam LocalTime time)
    				throws ParkingSlotNotFoundException, ParkingSlotAlreadyBookedException, ParkingSlotDoesNotHaveThisMovieException {
       return movieTicketService.bookTicket(carNumber, movieTitle, slotNumber, date, time);
       
	}	
	
	
    @DeleteMapping("/cancel-booking/{ticketId}")
    public String cancelTicket(@PathVariable String ticketId) throws TicketNotFoundException 
    {
    	movieTicketService.cancelBooking(ticketId);
    	return "Ticket Cancelled";
    }

    @GetMapping("/view-booking-details/{ticketId}")
    public List<Object> getTicketDetails(@PathVariable String ticketId) throws TicketNotFoundException {
        return movieTicketService.viewBookingDetails(ticketId);
    }
	
}


