package com.travellerapp.user.otpauth.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "user_profile")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class UserProfile {
	@Id
	private long mobileno;
	private String username;
	private String email;
	private LocalDate created_date;
	private LocalDate updated_date;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role;

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public LocalDate getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(LocalDate updated_date) {
		this.updated_date = updated_date;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(created_date, email, mobileno, role, updated_date, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(created_date, other.created_date) && Objects.equals(email, other.email)
				&& mobileno == other.mobileno && Objects.equals(role, other.role)
				&& Objects.equals(updated_date, other.updated_date) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserProfile [mobileno=" + mobileno + ", username=" + username + ", email=" + email + ", role_id="
				+", created_date=" + created_date + ", updated_date=" + updated_date + ", role=" + role
				+ "]";
	}
}
