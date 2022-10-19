package com.jobportal.dto;

import java.util.List;
import java.util.Objects;

import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Job;
import com.jobportal.entity.Recruiter;

public class RecruiterDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private Job postedJobs;
	private Feedback Feedbacks;
	private BookmarkedFreelancer freelancers;
	
	
	
	public RecruiterDTO() {
		super();
	}
	
	
	public RecruiterDTO(int id, String firstName, String lastName, Job postedJobs, Feedback feedbacks,
			BookmarkedFreelancer freelancers) {
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
	public Recruiter toRecruiter() {
		Recruiter recruiter = new Recruiter();
		recruiter.setFirstName(this.firstName);
		recruiter.setLastName(this.lastName);
		recruiter.setFeedbacks(this.Feedbacks);
		recruiter.setFreelancers(this.freelancers);
		recruiter.setPostedJobs(this.postedJobs);
		return recruiter;
	}


	
	

}
