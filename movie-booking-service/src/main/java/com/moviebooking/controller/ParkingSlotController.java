package com.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.exception.ParkingSlotNotFoundException;
import com.moviebooking.model.ParkingSlot;
import com.moviebooking.repository.ParkingSlotRepository;
import com.moviebooking.service.IParkingSlotService;

@RestController
@RequestMapping("/parking-slot")
public class ParkingSlotController {
	
//	@Autowired
//	private MovieTicketBookingService movieTicketBookingService;
	
	@Autowired
	private ParkingSlotRepository repository;
	
	@Autowired
	private IParkingSlotService parkingSlotService;
	
	@GetMapping("/view/{slotNumber}")
	public ParkingSlot viewParkingSlot(@PathVariable int slotNumber) throws ParkingSlotNotFoundException{
		return parkingSlotService.getParkingSlotBySlotNumber(slotNumber);
		
	}
	
	@GetMapping("/view-all")
	public List<ParkingSlot> viewAllParking(){
		
		return parkingSlotService.viewAllParkingSlotId();
	}
	
	@DeleteMapping("/delete/{slotNumber}")
	public ParkingSlot deleteParking(@PathVariable int slotNumber) throws ParkingSlotNotFoundException {
		
		return parkingSlotService.deleteParkingSlot(slotNumber);
	
	}
	
	@PostMapping("/add")
	public void addParkingSlot(@RequestBody ParkingSlot parkingSlot) {
		parkingSlotService.addParkingSlot(parkingSlot);
		
		
	}
	
	@GetMapping("/add-all")
	public List<ParkingSlot> addParkingSlotByLoop() {
		for(int i=1; i<61; i++) {
			repository.save(
				new ParkingSlot(i, true)	
			);
		}
		
		return repository.findAll();
		
	}
	
	@PutMapping("/update-parking-slot/{slotNumber}/{price}")
	public ParkingSlot updateParkingSlot(@PathVariable int slotNumber,@PathVariable double price) throws ParkingSlotNotFoundException {
		return parkingSlotService.updateParkingSlot(slotNumber, price);
	}
	
	
	
	

}