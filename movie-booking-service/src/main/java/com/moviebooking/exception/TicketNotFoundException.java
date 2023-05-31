package com.moviebooking.exception;

@SuppressWarnings("serial")
public class TicketNotFoundException extends Exception {

	public TicketNotFoundException(String msg) {
		super(msg);
	}
}
