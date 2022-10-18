package com.jobportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.jobportal.dto.BookmarkedFreelancerDTO;

@Entity
public class BookmarkedFreelancer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Entering a skill is mandatory")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id", unique = true)
	private Skill skill;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancer_id", unique = true)
	@NotNull(message="Entering a freelancer is mandatory")
	private Freelancer freelancer;
	@NotNull(message="Entering a skill is mandatory")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruiter_id", unique = true)
	private Recruiter bookmarkedBy;
	
	public BookmarkedFreelancer() {
		super();
	}
	
	public BookmarkedFreelancer(int id, Recruiter bookmarkedBy, Skill skill, Freelancer freelancer) {
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
	
	public BookmarkedFreelancerDTO toBookmarkedFreelancerDTO() {
		BookmarkedFreelancerDTO bookmarkedFreelancerDTO = new BookmarkedFreelancerDTO();
		bookmarkedFreelancerDTO.setId(this.getId());
		bookmarkedFreelancerDTO.setBookmarkedBy(this.bookmarkedBy);
		bookmarkedFreelancerDTO.setFreelancer(this.freelancer);
		bookmarkedFreelancerDTO.setSkill(this.getSkill());
		return bookmarkedFreelancerDTO;
	}

}

