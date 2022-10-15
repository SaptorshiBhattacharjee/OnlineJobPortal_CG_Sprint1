package com.jobportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.Skill;
import com.jobportal.entity.SkillExperience;
import com.jobportal.repository.ISkillExperienceDao;

@Service
@Transactional
public class ISkillExperienceServiceImpl implements ISkillExperienceService{
	
	@Autowired
	ISkillExperienceDao iSkillExperienceDao;
	Skill skill;
	
	@Override			
	public SkillExperience addSkill(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception{
		SkillExperience se = null;
		se.setSkill(skill);
		List<SkillExperience> skills=freelancerDTO.getSkills();
		skills.add(se);	
		return se;			
	}
	
	@Override
	public SkillExperience updateSkillYears(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception{		
		SkillExperience se = null;
		se.setYears(ExperienceYears);
		List<SkillExperience> skills=freelancerDTO.getSkills();
		skills.add(se);	
		return se;
	}	

}
