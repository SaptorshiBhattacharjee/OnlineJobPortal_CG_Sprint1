package com.jobportal.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.jobportal.dto.AdminDTO;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Firstname should not be empty")
	private String firstName;
	@NotNull(message ="Lastname should not be empty")
	private String lastName;
	@NotNull(message ="Entering a username is mandatory")
	private String username;
	@NotNull(message ="Entering password is mandatory")
	private String password;
	

	public Admin() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public AdminDTO toAdminDTO() {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(this.id);
		adminDTO.setFirstName(this.firstName);
		adminDTO.setLastName(this.lastName);
		adminDTO.setUsername(this.username);
		adminDTO.setPassword(this.password);
		return adminDTO;
	}
}
