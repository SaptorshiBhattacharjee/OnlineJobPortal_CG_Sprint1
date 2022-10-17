
package com.jobportal.dto;

import com.jobportal.entity.Admin;

public class AdminDTO {
	private Integer id;
	private String firstName;
	private String lastName;
	private String password;
	
	public AdminDTO() {
		super();
	}
	
	public AdminDTO(Integer id, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ "]";
	}
	
	public Admin toAdmin() {
		Admin admin = new Admin();
		admin.setFirstName(this.firstName);
		admin.setLastName(this.lastName);
		admin.setPassword(this.password);
		return admin;
	}
	
}
