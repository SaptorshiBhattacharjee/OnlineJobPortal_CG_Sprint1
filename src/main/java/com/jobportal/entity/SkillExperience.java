package com.jobportal.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jobportal.dto.SkillExperienceDTO;

@Entity
public class SkillExperience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id", unique = true)
	private Skill skill;
	private Integer years;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancer_id", unique = true)
	private Freelancer freelancer;
	
	public SkillExperience () {
		super();
	}
	
	public SkillExperience(int id, Skill skill, Integer years, Freelancer freelancer) {
		super();
		this.id = id;
		this.skill = skill;
		this.years = years;
		this.freelancer = freelancer;
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
	public int hashCode() {
		return 31;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillExperience other = (SkillExperience) obj;
		return Objects.equals(id, other.id) && Objects.equals(years, other.years)
				&& Objects.equals(skill, other.skill) && Objects.equals(freelancer, other.freelancer);
	}
	
@Override
public String toString() {
	return "SkillExperience [id=" + id + ", skill=" + skill + ", years=" + years + ", freelancer=" + freelancer
			+ "]";
}		

public SkillExperienceDTO toSkillExperienceDTO() {
	SkillExperienceDTO skillExperienceDTO = new SkillExperienceDTO();
	skillExperienceDTO.setSkill(this.skill);
	skillExperienceDTO.setYears(this.years);
	skillExperienceDTO.setFreelancer(this.freelancer);
	return skillExperienceDTO;
}
}
