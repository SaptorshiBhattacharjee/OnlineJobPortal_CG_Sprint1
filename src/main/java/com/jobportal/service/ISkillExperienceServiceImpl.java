package com.jobportal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.dto.SkillExperienceDTO;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Skill;
import com.jobportal.entity.SkillExperience;
import com.jobportal.exception.InvalidSkillExperienceException;
import com.jobportal.repository.ISkillExperienceDao;

@Service
@Transactional
public class ISkillExperienceServiceImpl implements ISkillExperienceService{
	
	@Autowired
	ISkillExperienceDao iSkillExperienceDao;

	
	@Override			
	public SkillExperienceDTO addSkill(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws InvalidSkillExperienceException{
		Skill skill = new Skill();
		skill.setId(skillDTO.getId());	
		Freelancer freelancer = new Freelancer();
		freelancer.setId(freelancerDTO.getId());
		List<SkillExperience> skills=freelancerDTO.getSkills();
		
		int idskill =0;
		int count = 0;
		for(SkillExperience skillexp : skills) {			
			if(skillexp.getSkill().equals(skill)) {
				count++;
				idskill = skillexp.getId();
				break;
			}
		}
		if(count > 0) {
			throw new InvalidSkillExperienceException("Service.ALREADY_APPLIED");
		}
		SkillExperience skillExperience = new SkillExperience();
		skillExperience.setSkill(skill);
		skillExperience.setFreelancer(freelancer);
		skillExperience.setYears(ExperienceYears);
		iSkillExperienceDao.save(skillExperience);
		
		SkillExperienceDTO skillExperienceDTO = new SkillExperienceDTO();
		skillExperienceDTO.setId(skillExperience.getId());
		skillExperienceDTO.setSkill(skill);
		skillExperienceDTO.setYears(skillExperience.getYears());	
		skillExperienceDTO.setFreelancer(freelancer);		
		return skillExperienceDTO;
	}
	
	@Override
	public SkillExperienceDTO updateSkillYears(SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws InvalidSkillExperienceException{		
		Skill skill = new Skill();
	skill.setId(skillDTO.getId());	
	Freelancer freelancer = new Freelancer();
	freelancer.setId(freelancerDTO.getId());
		List<SkillExperience> skills=freelancerDTO.getSkills();
		
		int idskill = 0;;
		int count = 0;
		for(SkillExperience skillexp : skills) {
			
			if(skillexp.getSkill().equals(skill)) {
				count++;
				idskill = skillexp.getId();
				break;
			}
		}
		if(count == 0) {
			throw new InvalidSkillExperienceException("Service.NOT_Found");
		}
				
		Optional<SkillExperience> optional = iSkillExperienceDao.findById(idskill);
		SkillExperience skillExperience = optional.orElseThrow(() -> new InvalidSkillExperienceException("NOT UPDATED"));
		skillExperience.setYears(ExperienceYears);
		
		SkillExperienceDTO skillExperienceDTO = new SkillExperienceDTO();
		skillExperienceDTO.setId(skillExperience.getId());
		skillExperienceDTO.setSkill(skill);
		skillExperienceDTO.setYears(skillExperience.getYears());	
		skillExperienceDTO.setFreelancer(freelancer);
		return skillExperienceDTO;
	}
		
}		
		
		
//		if (iSkillExperienceDao.existsById(skillDTO.getId())) {
//		SkillExperience skillExperience = iSkillExperienceDao.findBySkillIdAndFreelancerId(skillDTO.getId(), freelancerDTO.getId());
//		skillExperience.setYears(ExperienceYears);
//		iSkillExperienceDao.save(skillExperience);
//		
//		SkillExperienceDTO skillExperienceDTO;
//		skillExperienceDTO.setYears(ExperienceYears);
//		iSkillExperienceDao.save(skillExperience);
//		return skillExperienceDTO;
//	} else
//		throw new Exception("Service.ALREADY_UPDATED");		

