package com.jobportal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.SkillExperience;

public interface ISkillExperienceDao extends CrudRepository<SkillExperience, Integer> {

	Optional<SkillExperience> findBySkillIdAndFreelancerId(int skillId, int freelancerId);
	
}
