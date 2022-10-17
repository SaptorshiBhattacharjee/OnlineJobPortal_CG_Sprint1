package com.jobportal.dto;

import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Skill;
import com.jobportal.entity.SkillExperience;

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
	
	public SkillExperience toSkillExperience() {
		SkillExperience skillExperience = new SkillExperience();
		skillExperience.setSkill(this.skill);
		skillExperience.setYears(this.years);
		skillExperience.setFreelancer(this.freelancer);
		return skillExperience;
	}
}