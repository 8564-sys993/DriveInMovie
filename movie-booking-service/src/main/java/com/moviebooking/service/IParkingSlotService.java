package com.moviebooking.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.moviebooking.exception.ParkingSlotNotFoundException;
import com.moviebooking.model.ParkingSlot;

public interface IParkingSlotService {
	public ParkingSlot getParkingSlotBySlotNumber(int slotNumber) throws ParkingSlotNotFoundException;

	public List<ParkingSlot> viewAllParkingSlotId();

	public ParkingSlot deleteParkingSlot(int slotNumber) throws ParkingSlotNotFoundException;

	public void addParkingSlot(@RequestBody ParkingSlot parkingSlot);

	public ParkingSlot updateParkingSlot(int slotNumber, double price) throws ParkingSlotNotFoundException;

}
