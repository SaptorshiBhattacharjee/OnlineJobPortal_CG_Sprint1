package com.jobportal.dto;

import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Freelancer;

import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;

import javax.validation.constraints.NotNull;

public class BookmarkedFreelancerDTO {
	private int id;
	@NotNull(message = "Customer name should not be empty")
	private Skill skill;
	@NotNull(message = "Freelancer details are missing")
	private Freelancer freelancer;
	@NotNull(message = "Recruiter details are missing")
	private Recruiter bookmarkedBy;
	
	
	
	
	public BookmarkedFreelancerDTO() {
		super();
	}
	
	
	public BookmarkedFreelancerDTO(int id, Skill skill, Freelancer freelancer, Recruiter bookmarkedBy) {
		super();
		this.id = id;
		this.skill = skill;
		this.freelancer = freelancer;
		this.bookmarkedBy = bookmarkedBy;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
	public Recruiter getBookmarkedBy() {
		return bookmarkedBy;
	}
	public void setBookmarkedBy(Recruiter bookmarkedBy) {
		this.bookmarkedBy = bookmarkedBy;
	}
	
	
	@Override
	public String toString() {
		return "BookmarkedFreelancerDTO [id=" + id + ", skill=" + skill + ", freelancer=" + freelancer
				+ ", bookmarkedBy=" + bookmarkedBy + "]";
	}
	
	public BookmarkedFreelancer toBookmarkedFreelancer() {
		BookmarkedFreelancer bookmarkedFreelancer = new BookmarkedFreelancer();
		bookmarkedFreelancer.setId(this.getId());
		bookmarkedFreelancer.setBookmarkedBy(this.bookmarkedBy);
		bookmarkedFreelancer.setFreelancer(this.freelancer);
		bookmarkedFreelancer.setSkill(this.getSkill());
		return bookmarkedFreelancer;
	}
	

}

