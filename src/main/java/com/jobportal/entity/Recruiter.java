package com.jobportal.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jobportal.dto.AdminDTO;
import com.jobportal.dto.RecruiterDTO;

@Entity
public class Recruiter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="job_id")
	private Job postedJobs;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="feedback_id")
	private Feedback Feedbacks;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bookmarkedfreelancer_id")
	private BookmarkedFreelancer freelancers;
	
	
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
	public Job getPostedJobs() {
		return postedJobs;
	}
	public void setPostedJobs(Job postedJobs) {
		this.postedJobs = postedJobs;
	}
	public Feedback getFeedbacks() {
		return Feedbacks;
	}
	public void setFeedbacks(Feedback feedbacks) {
		Feedbacks = feedbacks;
	}
	public BookmarkedFreelancer getFreelancers() {
		return freelancers;
	}
	public void setFreelancers(BookmarkedFreelancer freelancers) {
		this.freelancers = freelancers;
	}
	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Feedbacks="
				+ Feedbacks + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Feedbacks, firstName, id, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recruiter other = (Recruiter) obj;
		return Objects.equals(Feedbacks, other.Feedbacks) && Objects.equals(firstName, other.firstName)
				&& id == other.id && Objects.equals(lastName, other.lastName);
	}
	public RecruiterDTO toRecruiterDTO() {
		RecruiterDTO recruiterDTO = new RecruiterDTO();
		recruiterDTO.setFirstName(this.firstName);
		recruiterDTO.setLastName(this.lastName);
		recruiterDTO.setFeedbacks(this.Feedbacks);
		recruiterDTO.setFreelancers(this.freelancers);
		recruiterDTO.setPostedJobs(this.postedJobs);
		return recruiterDTO;
	}
	
	
	

}

