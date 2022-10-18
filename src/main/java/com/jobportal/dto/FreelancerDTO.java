package com.jobportal.dto;

import java.util.List;

import com.jobportal.entity.BookmarkedJob;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.JobApplication;
import com.jobportal.entity.SkillExperience;

public class FreelancerDTO 
{
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private JobApplication appliedJobs;
	private Feedback feedbacks;
	private SkillExperience skills;
	private BookmarkedJob bookmarkedJobs;
	
	// defining the getter and setter methods
	
	
	
	// constructors with parameters
	public FreelancerDTO(int id, String firstName, String lastName, String password, JobApplication appliedJobs,
			Feedback feedbacks, SkillExperience skills, BookmarkedJob bookmarkedJobs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.appliedJobs = appliedJobs;
		this.feedbacks = feedbacks;
		this.skills = skills;
		this.bookmarkedJobs = bookmarkedJobs;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JobApplication getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(JobApplication appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public Feedback getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Feedback feedbacks) {
		this.feedbacks = feedbacks;
	}

	public SkillExperience getSkills() {
		return skills;
	}

	public void setSkills(SkillExperience skills) {
		this.skills = skills;
	}

	public BookmarkedJob getBookmarkedJobs() {
		return bookmarkedJobs;
	}

	public void setBookmarkedJobs(BookmarkedJob bookmarkedJobs) {
		this.bookmarkedJobs = bookmarkedJobs;
	}

	// default constructor
	public FreelancerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	//defining toString method
	@Override
	public String toString() {
		return "FreelancerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", appliedJobs=" + appliedJobs + ", feedbacks=" + feedbacks + ", skills=" + skills
				+ ", bookmarkedJobs=" + bookmarkedJobs + "]";
	}
	public Freelancer toFreelancerEntity()
	{
		Freelancer freelancer = new Freelancer();
		freelancer.setId(this.getId());
		freelancer.setFirstName(this.getFirstName());
		freelancer.setLastName(this.getLastName());
		freelancer.setPassword(this.getPassword());
		freelancer.setAppliedJobs(this.getAppliedJobs());
		freelancer.setFeedbacks(this.getFeedbacks());
		freelancer.setSkills(this.getSkills());
		freelancer.setBookmarkedJobs(this.getBookmarkedJobs());
		
		return(freelancer);
	}
}
