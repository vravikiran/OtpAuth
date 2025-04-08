package com.travellerapp.user.otpauth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travellerapp.user.otpauth.entities.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	@Query(value = "select u from UserProfile u where u.email= :email")
	public Optional<UserProfile> findByEmail(String email);
}
