package com.travellerapp.user.otpauth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travellerapp.user.otpauth.entities.UserProfile;
import com.travellerapp.user.otpauth.services.UserProfileService;

@Controller
@RequestMapping("/userprofile")
public class UserProfileController {
	Logger logger = LoggerFactory.getLogger(UserProfileController.class);
	@Autowired
	UserProfileService userProfileService;

	@PostMapping
	public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) throws Exception {
		logger.info("creating user profile with details :: " + userProfile.toString());
		UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);
		logger.info("creation of user profile successful");
		return ResponseEntity.ok(createdUserProfile);
	}

	@PostMapping("/admin")
	@PreAuthorize("hasAuthority('SUPER_ADMIN')")
	public ResponseEntity<UserProfile> createAdminUser(@RequestBody UserProfile userProfile) throws Exception {
		userProfileService.createUserProfile(userProfile);
		return ResponseEntity.ok(userProfile);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('TRAVELLER')")
	public ResponseEntity<UserProfile> getUserProfile(@RequestParam long mobileno) {
		UserProfile userProfile = userProfileService.getUserProfileByMobileNo(Long.valueOf(mobileno));
		return ResponseEntity.ok(userProfile);
	}

}
