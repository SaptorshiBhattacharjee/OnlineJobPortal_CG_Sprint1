package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.FreelancerDTO;

import com.jobportal.dto.SkillDTO;
import com.jobportal.dto.SkillExperienceDTO;
import com.jobportal.service.ISkillExperienceService;

@RestController
@RequestMapping("value=/skillexperience")
@CrossOrigin(origins = "*")
public class SkillExperienceAPI {
	
	@Autowired
	private ISkillExperienceService iSkillExperienceService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/addskill")
	public ResponseEntity<String> addSkill(@RequestBody SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception{
		SkillExperienceDTO Applied = iSkillExperienceService.addSkill(skillDTO, freelancerDTO, ExperienceYears);
		String successMessage = environment.getProperty("API.APPLIED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value="/updateskillyears")
	public ResponseEntity<String> updateSkillYears(@RequestBody SkillDTO skillDTO, FreelancerDTO freelancerDTO, int ExperienceYears) throws Exception{
		SkillExperienceDTO updated = iSkillExperienceService.updateSkillYears(skillDTO, freelancerDTO, ExperienceYears);
		String successMessage = environment.getProperty("API.UPDATED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
}
