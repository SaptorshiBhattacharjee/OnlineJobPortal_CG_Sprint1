package com.jobportal.dto;

import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.Skill;

public class BookmarkedJobDTO 
{
	
	private Long id;
	private Skill skill;
	private Job job;
	private Freelancer freelancer;
	
	// defining the getter and setter methods
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
	
	//defining toString method
	@Override
	public String toString() {
		return "BookmarkedJobDTO [id=" + id + ", skill=" + skill + ", job=" + job + ", freelancer=" + freelancer + "]";
	}
}
