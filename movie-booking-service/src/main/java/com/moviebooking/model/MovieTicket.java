package com.moviebooking.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movieTickets")
public class MovieTicket {
	
	@Id
    private String id;
    private String carNumber;
    private String movieTitle;
    private int slotNumber;
    private double price;
    private String status;
    private LocalDate date;
    private LocalTime time;
    
    public MovieTicket() {
    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MovieTicket(String carNumber, String movieTitle, int slotNumber, String status, LocalDate date,
			LocalTime time) {
		super();
		this.carNumber = carNumber;
		this.movieTitle = movieTitle;
		this.slotNumber = slotNumber;
		this.status = status;
		this.date = date;
		this.time = time;
		calculatePrice();
	}


	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public void calculatePrice() {

		double price = 0;
		if (slotNumber >= 1 && slotNumber <= 20) {
			price = 1000;
		} else if (slotNumber >= 21 && slotNumber <= 40) {
			price = 700;
		} else {
			price = 300;
		}
		this.price=price;
	}
}
