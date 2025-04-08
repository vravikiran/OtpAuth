package com.travellerapp.user.otpauth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travellerapp.user.otpauth.entities.Itinerary;
import com.travellerapp.user.otpauth.services.ItineraryService;

@RestController
@RequestMapping("/itinerary")
public class ItineraryController {
	@Autowired
	ItineraryService itineraryService;

	@PreAuthorize("hasAnyAuthority('SUPER_ADMIN','ADMIN')")
	@PostMapping
	public ResponseEntity<Itinerary> createitinerary(@RequestBody Itinerary itinerary) {
		Itinerary createdItinerary = itineraryService.createItinerary(itinerary);
		return ResponseEntity.ok(createdItinerary);
	}

	@GetMapping
	public ResponseEntity<List<Itinerary>> getItineries() {
		return null;
	}
}
