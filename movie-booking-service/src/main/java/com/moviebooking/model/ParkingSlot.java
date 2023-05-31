package com.moviebooking.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parkingslot")
public class ParkingSlot {

//	@Id
//	@Field("_id")
//	// @GeneratedValue(strategy = GenerationType.AUTO)
//	private String id;

	@Id
	@NotNull
	@Size(min = 1, max = 60)
	private int slotNumber;
	private boolean available;

	public ParkingSlot() {
	}

	public ParkingSlot(@NotNull @Size(min = 2, max = 30) int slotNumber, boolean available) {
		super();
		this.slotNumber = slotNumber;
		this.available = available;
	}


	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}



