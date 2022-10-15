package com.jobportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BookmarkedFreelancer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id", unique = true)
	private Skill skill;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancer_id", unique = true)
	private Freelancer freelancer;
	//Is there any relation to be add here?
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruiter_id", unique = true)
	private Recruiter bookmarkedBy;
	
	public BookmarkedFreelancer(long id, Recruiter bookmarkedBy, Skill skill, Freelancer freelancer) {
		super();
		this.id = id;
		this.skill = skill;
		this.freelancer = freelancer;
		this.bookmarkedBy = bookmarkedBy;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	

}

