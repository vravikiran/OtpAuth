package com.travellerapp.user.otpauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travellerapp.user.otpauth.entities.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
	@Query(value="update Itinerary set isactive = true where itinerary_id = :itinerary_id")
	public void deactivateItinerary(long itinerary_id);
}
