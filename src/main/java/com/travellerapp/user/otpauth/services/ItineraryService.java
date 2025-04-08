package com.travellerapp.user.otpauth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travellerapp.user.otpauth.entities.Itinerary;
import com.travellerapp.user.otpauth.repositories.ItineraryRepository;

@Service
public class ItineraryService {
	@Autowired
	ItineraryRepository itineraryRepository;
	
	public Itinerary createItinerary(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}
	
	public List<Itinerary> getItineries() {
		return itineraryRepository.findAll();
	}
}
