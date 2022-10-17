package com.jobportal.dto;

import java.util.List;

import com.jobportal.entity.BookmarkedJob;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.JobApplication;
import com.jobportal.entity.SkillExperience;

public class FreelancerDTO 
{
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private List<JobApplication> appliedJobs;
	private List<Feedback> feedbacks;
	private List<SkillExperience> skills;
	private List<BookmarkedJob> bookmarkedJobs;
	
	// defining the getter and setter methods
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<JobApplication> getAppliedJobs() {
		return appliedJobs;
	}
	public void setAppliedJobs(List<JobApplication> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public List<SkillExperience> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillExperience> skills) {
		this.skills = skills;
	}
	public List<BookmarkedJob> getBookmarkedJobs() {
		return bookmarkedJobs;
	}
	public void setBookmarkedJobs(List<BookmarkedJob> bookmarkedJobs) {
		this.bookmarkedJobs = bookmarkedJobs;
	}
	
	//defining toString method
	@Override
	public String toString() {
		return "FreelancerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", appliedJobs=" + appliedJobs + ", feedbacks=" + feedbacks + ", skills=" + skills
				+ ", bookmarkedJobs=" + bookmarkedJobs + "]";
	}
}
