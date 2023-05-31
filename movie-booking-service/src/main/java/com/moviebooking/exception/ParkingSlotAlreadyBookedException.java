package com.moviebooking.exception;

@SuppressWarnings("serial")
public class ParkingSlotAlreadyBookedException extends Exception {

	public ParkingSlotAlreadyBookedException(String msg) {
		super(msg);
	}
}
