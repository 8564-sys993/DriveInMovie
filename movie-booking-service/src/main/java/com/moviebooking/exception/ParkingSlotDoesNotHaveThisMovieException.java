package com.moviebooking.exception;

@SuppressWarnings("serial")
public class ParkingSlotDoesNotHaveThisMovieException extends Exception {
	
	public ParkingSlotDoesNotHaveThisMovieException(String msg) {
		
		super(msg);
	}

}
