package com.travellerapp.user.otpauth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AuthorizationDeniedException.class)
	public ResponseEntity<String> handleAuthorizationDeniedException() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access is denied for user to perform this opertaion");
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> handleUnauthorizedUsers(UsernameNotFoundException usernameNotFoundException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usernameNotFoundException.getMessage());
	}
}
