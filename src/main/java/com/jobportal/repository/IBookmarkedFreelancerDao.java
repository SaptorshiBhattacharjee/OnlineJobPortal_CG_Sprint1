package com.jobportal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.service.SkillDTO;

public interface IBookmarkedFreelancerDao extends CrudRepository<BookmarkedFreelancer, Integer>{

	@Query("DELETE FROM BookmarkedFreelancer bf WHERE bf.freelancer = :freelancer AND bf.bookmarkedby = :recruiter AND bf.skill = skill")
	@Modifying
	@Transactional
	Integer removeBookmarkedFreelancer(@Param("freelancer") Freelancer freelancer,@Param("skill") Skill skill, @Param("recruiter") Recruiter recruiter);
}


//FreelancerDTO freelancerDTO, SkillDTO skillDTO, RecruiterDTO recruiterDTO