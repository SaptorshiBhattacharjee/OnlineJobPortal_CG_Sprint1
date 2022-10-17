package com.jobportal.service;

import com.jobportal.dto.FreelancerDTO;

import com.jobportal.dto.SkillDTO;
import com.jobportal.dto.SkillExperienceDTO;
import com.jobportal.exception.InvalidSkillExperienceException;



public interface ISkillExperienceService {
	
	public SkillExperienceDTO addSkill(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws InvalidSkillExperienceException;
	
	public SkillExperienceDTO updateSkillYears(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws InvalidSkillExperienceException;
}
