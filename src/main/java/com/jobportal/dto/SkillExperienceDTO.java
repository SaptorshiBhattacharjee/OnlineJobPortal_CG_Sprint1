package com.jobportal.dto;

import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Skill;

public class SkillExperienceDTO {
	private int id;
	private Skill skill;
	private Integer years;
	private Freelancer freelancer;
	
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
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
	@Override
	public String toString() {
		return "SkillExperience [id=" + id + ", skill=" + skill + ", years=" + years + ", freelancer=" + freelancer
				+ "]";
	}
}
