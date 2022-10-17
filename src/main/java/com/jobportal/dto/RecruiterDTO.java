package com.jobportal.dto;

import java.util.List;
import java.util.Objects;

import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Job;

public class RecruiterDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private List<Job> postedJobs;
	private List<Feedback> Feedbacks;
	private List<BookmarkedFreelancer> freelancers;
	
	
	
	public RecruiterDTO() {
		super();
	}
	
	
	public RecruiterDTO(int id, String firstName, String lastName, List<Job> postedJobs, List<Feedback> feedbacks,
			List<BookmarkedFreelancer> freelancers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.postedJobs = postedJobs;
		Feedbacks = feedbacks;
		this.freelancers = freelancers;
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
	public List<Job> getPostedJobs() {
		return postedJobs;
	}
	public void setPostedJobs(List<Job> postedJobs) {
		this.postedJobs = postedJobs;
	}
	public List<Feedback> getFeedbacks() {
		return Feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		Feedbacks = feedbacks;
	}
	public List<BookmarkedFreelancer> getFreelancers() {
		return freelancers;
	}
	public void setFreelancers(List<BookmarkedFreelancer> freelancers) {
		this.freelancers = freelancers;
	}
	@Override
	public String toString() {
		return "RecruiterDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", postedJobs="
				+ postedJobs + ", Feedbacks=" + Feedbacks + ", freelancers=" + freelancers + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Feedbacks, firstName, freelancers, id, lastName, postedJobs);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecruiterDTO other = (RecruiterDTO) obj;
		return Objects.equals(Feedbacks, other.Feedbacks) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(freelancers, other.freelancers) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(postedJobs, other.postedJobs);
	}
	
	

}
