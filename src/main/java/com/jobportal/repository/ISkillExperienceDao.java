package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.SkillExperience;

public interface ISkillExperienceDao extends CrudRepository<SkillExperience, Integer> {
	
}
