package com.moviebooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.model.ParkingSlot;

@Repository
public interface ParkingSlotRepository extends MongoRepository<ParkingSlot, Integer>{
	
	Optional<ParkingSlot> findBySlotNumber(int slotNumber);
	
	List<ParkingSlot> findByAvailable(boolean availale);
	
}
