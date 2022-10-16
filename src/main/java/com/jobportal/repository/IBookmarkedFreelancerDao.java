package com.jobportal.repository;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.exception.JobPortalException;
import com.jobportal.dto.SkillDTO;

public interface IBookmarkedFreelancerDao extends CrudRepository<BookmarkedFreelancer, Integer>{

	@Query("SELECT bf FROM BookmarkedFreelancer bf WHERE bf.skill = :skill AND bf.recruiter = :recruiter")
	List<BookmarkedFreelancer> findBookmarkedFreelancerBySkill(@Param("skill") Skill skill, @Param("recruiter") Recruiter recruiter );
	
	@Query("DELETE FROM BookmarkedFreelancer bf WHERE bf.freelancer = :freelancer AND bf.bookmarkedby = :recruiter AND bf.skill = skill")
	@Modifying
	@Transactional
	Integer removeBookmarkedFreelancer(@Param("freelancer") Freelancer freelancer,@Param("skill") Skill skill, @Param("recruiter") Recruiter recruiter);
	
	
}


//FreelancerDTO freelancerDTO, SkillDTO skillDTO, RecruiterDTO recruiterDTO