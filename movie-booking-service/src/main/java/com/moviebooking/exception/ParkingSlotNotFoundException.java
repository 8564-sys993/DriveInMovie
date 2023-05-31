package com.moviebooking.exception;

@SuppressWarnings("serial")
public class ParkingSlotNotFoundException extends Exception{

	public ParkingSlotNotFoundException(String msg) {
		super(msg);
	}
}
