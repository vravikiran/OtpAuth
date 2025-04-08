package com.travellerapp.user.otpauth.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.travellerapp.user.otpauth.entities.Role;
import com.travellerapp.user.otpauth.entities.UserInfoDetails;
import com.travellerapp.user.otpauth.entities.UserProfile;
import com.travellerapp.user.otpauth.enums.RoleTypeEnum;
import com.travellerapp.user.otpauth.repositories.UserProfileRepository;

@Service
public class UserProfileService implements UserDetailsService {
	@Autowired
	UserProfileRepository userProfileRepository;
	
	public UserProfile createUserProfile(UserProfile userProfile) {
		userProfile.setCreated_date(LocalDate.now());
		userProfile.setUpdated_date(LocalDate.now());
		Role role = new Role(RoleTypeEnum.TRAVELLER.getRoleid(),RoleTypeEnum.TRAVELLER.getRole_name());
		userProfile.setRole(role);
		return userProfileRepository.save(userProfile);
	}
	
	public UserDetails loadUserByUsername(String username) {
		Optional<UserProfile> userProfile = userProfileRepository.findById(Long.valueOf(username));
		return userProfile.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with given mobileNo " + username));
	}

	public UserInfoDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		Optional<UserProfile> userProfile = userProfileRepository.findByEmail(email);
		return userProfile.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with given email " + email));
	}
	
	public UserProfile getUserProfileByMobileNo(long mobileno) {
		return userProfileRepository.getReferenceById(mobileno);
	}
}
