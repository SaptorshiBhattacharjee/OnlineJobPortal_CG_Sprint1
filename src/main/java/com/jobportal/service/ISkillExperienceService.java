package com.jobportal.service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.SkillExperience;

public interface ISkillExperienceService {
	
	public SkillExperience addSkill(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception;
	
	public SkillExperience updateSkillYears(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception;

}
