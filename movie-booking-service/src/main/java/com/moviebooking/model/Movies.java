package com.moviebooking.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movies {
	private Long id;

	private String title;

	private LocalDate date;
	private LocalTime time;

	public Movies() {
	}

	public Movies(Long id, String title, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
