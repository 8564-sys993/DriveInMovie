package com.moviebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.moviebooking.exception.ParkingSlotNotFoundException;
import com.moviebooking.model.ParkingSlot;
import com.moviebooking.repository.ParkingSlotRepository;

@Service
public class ParkingSlotServiceImpl implements IParkingSlotService{

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;

	public ParkingSlot getParkingSlotBySlotNumber(int slotNumber) throws ParkingSlotNotFoundException {
		return parkingSlotRepository.findBySlotNumber(slotNumber)
				.orElseThrow(() -> new ParkingSlotNotFoundException("Parking slot not found"));

	}

	public List<ParkingSlot> viewAllParkingSlotId() {

		return parkingSlotRepository.findAll();
	}

	public ParkingSlot deleteParkingSlot(int slotNumber) throws ParkingSlotNotFoundException {
		ParkingSlot parking = getParkingSlotBySlotNumber(slotNumber);

		parkingSlotRepository.delete(parking);
		return parking;
	}

	public void addParkingSlot(@RequestBody ParkingSlot parkingSlot) {
		parkingSlotRepository.save(parkingSlot);
	}

	public ParkingSlot updateParkingSlot(int slotNumber, double price) throws ParkingSlotNotFoundException {
		ParkingSlot parking = getParkingSlotBySlotNumber(slotNumber);
		// parking.setSeatType(seatType);
		parkingSlotRepository.save(parking);
		return parking;
	}

}