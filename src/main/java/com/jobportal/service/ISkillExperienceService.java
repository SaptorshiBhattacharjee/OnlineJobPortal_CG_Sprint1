package com.jobportal.service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.dto.SkillExperienceDTO;


public interface ISkillExperienceService {
	
	public SkillExperienceDTO addSkillExperience(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception;
	
	public SkillExperienceDTO updateSkillExperience(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception;

}
