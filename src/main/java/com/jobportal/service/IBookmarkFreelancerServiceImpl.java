package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.IBookmarkedFreelancerDao;

@Service(value="iBookmarkFreelancerService")
@Transactional
public class IBookmarkFreelancerServiceImpl implements IBookmarkFreelancerService {
	
	@Autowired
	private IBookmarkedFreelancerDao iBookmarkedFreelancerDao;
	
	@Override
	public BookmarkedFreelancerDTO bookmarkFreelancer(FreelancerDTO freelancerDTO, SkillDTO skillDTO,
			RecruiterDTO recruiterDTO) throws JobPortalException {
		BookmarkedFreelancer bookmarkedFreelancer = new BookmarkedFreelancer();
		Freelancer freelancer = new Freelancer();
		Skill skill = new Skill();
		Recruiter recruiter = new Recruiter();
		
		freelancer.setId(freelancerDTO.getId());
		freelancer.setFirstName(freelancerDTO.getFirstName());
		freelancer.setLastName(freelancerDTO.getLastName());
		freelancer.setPassword(freelancer.getPassword());
		freelancer.setAppliedJobs(freelancerDTO.getAppliedJobs());
		freelancer.setBookmarkedJobs(freelancerDTO.getBookmarkedJobs());
		freelancer.setFeedbacks(freelancerDTO.getFeedbacks());
		freelancer.setSkills(freelancerDTO.getSkills());
		
		skill.setId(skillDTO.getId());
		skill.setName(skillDTO.getName());
		skill.setDescription(skillDTO.getDescription());
		
		recruiter.setId(recruiterDTO.getId());
		recruiter.setFirstName(recruiterDTO.getFirstName());
		recruiter.setLastName(recruiterDTO.getLastName());
		recruiter.setPostedJobs(recruiterDTO.getPostedJobs());
		recruiter.setFreelancers(recruiterDTO.getFreelancers());
		recruiter.setFeedbacks(recruiterDTO.getFeedbacks());
		
		bookmarkedFreelancer.setFreelancer(freelancer);
		bookmarkedFreelancer.setBookmarkedBy(recruiter);
		bookmarkedFreelancer.setSkill(skill);
		iBookmarkedFreelancerDao.save(bookmarkedFreelancer);
		BookmarkedFreelancerDTO bookmarkedFreelancerDTO = new BookmarkedFreelancerDTO();
		bookmarkedFreelancerDTO.setId(bookmarkedFreelancer.getId());
		bookmarkedFreelancerDTO.setFreelancer(bookmarkedFreelancer.getFreelancer());
		bookmarkedFreelancerDTO.setBookmarkedBy(bookmarkedFreelancer.getBookmarkedBy());
		bookmarkedFreelancerDTO.setSkill(bookmarkedFreelancer.getSkill());
		return bookmarkedFreelancerDTO;
	}

	@Override
	public List<BookmarkedFreelancerDTO> findBookmarkedFreelancerBySkill(SkillDTO skillDTO, RecruiterDTO recruiterDTO)
			throws JobPortalException {
		Skill skill = new Skill();
		Recruiter recruiter = new Recruiter();

		skill.setId(skillDTO.getId());
		skill.setName(skillDTO.getName());
		skill.setDescription(skillDTO.getDescription());
		
		recruiter.setId(recruiterDTO.getId());
		recruiter.setFirstName(recruiterDTO.getFirstName());
		recruiter.setLastName(recruiterDTO.getLastName());
		recruiter.setPostedJobs(recruiterDTO.getPostedJobs());
		recruiter.setFreelancers(recruiterDTO.getFreelancers());
		recruiter.setFeedbacks(recruiterDTO.getFeedbacks());
		
		List<BookmarkedFreelancer> bookmarkedFreelancersBySkill = iBookmarkedFreelancerDao.findBookmarkedFreelancerBySkill(skill, recruiter);
		List<BookmarkedFreelancerDTO> bookmarkedFreelancersDTOBySkill = new ArrayList<>();
		
		for(BookmarkedFreelancer bookmarkedFreelancer : bookmarkedFreelancersBySkill) {
			BookmarkedFreelancerDTO bookmarkedFreelancerDTO = new BookmarkedFreelancerDTO();
			bookmarkedFreelancerDTO.setId(bookmarkedFreelancer.getId());
			bookmarkedFreelancerDTO.setBookmarkedBy(bookmarkedFreelancer.getBookmarkedBy());
			bookmarkedFreelancerDTO.setFreelancer(bookmarkedFreelancer.getFreelancer());
			bookmarkedFreelancerDTO.setSkill(bookmarkedFreelancer.getSkill());
			
			bookmarkedFreelancersDTOBySkill.add(bookmarkedFreelancerDTO);
		}
		return bookmarkedFreelancersDTOBySkill;
		
	}

	@Override
	public void removeBookmarkedFreelancer(FreelancerDTO freelancerDTO, SkillDTO skillDTO, RecruiterDTO recruiterDTO)
			throws JobPortalException {
		Freelancer freelancer = new Freelancer();
		Skill skill = new Skill();
		Recruiter recruiter = new Recruiter();
		
		freelancer.setId(freelancerDTO.getId());
		freelancer.setFirstName(freelancerDTO.getFirstName());
		freelancer.setLastName(freelancerDTO.getLastName());
		freelancer.setPassword(freelancer.getPassword());
		freelancer.setAppliedJobs(freelancerDTO.getAppliedJobs());
		freelancer.setBookmarkedJobs(freelancerDTO.getBookmarkedJobs());
		freelancer.setFeedbacks(freelancerDTO.getFeedbacks());
		freelancer.setSkills(freelancerDTO.getSkills());
		
		skill.setId(skillDTO.getId());
		skill.setName(skillDTO.getName());
		skill.setDescription(skillDTO.getDescription());
		
		recruiter.setId(recruiterDTO.getId());
		recruiter.setFirstName(recruiterDTO.getFirstName());
		recruiter.setLastName(recruiterDTO.getLastName());
		recruiter.setPostedJobs(recruiterDTO.getPostedJobs());
		recruiter.setFreelancers(recruiterDTO.getFreelancers());
		recruiter.setFeedbacks(recruiterDTO.getFeedbacks());
		
		
		Integer count = iBookmarkedFreelancerDao.removeBookmarkedFreelancer(freelancer, skill, recruiter);
		if(count == 0) {
			throw new JobPortalException("Service.NOT_FOUND");
		}
		else {
			
		}
		
	}

	@Override
	public BookmarkedFreelancerDTO findById(int id) throws JobPortalException {
		Optional<BookmarkedFreelancer> optional = iBookmarkedFreelancerDao.findById(id);
		BookmarkedFreelancer bookmarkedFreelancer = optional.orElseThrow(() -> new JobPortalException("Service.NOT_FOUND") );
		
		BookmarkedFreelancerDTO bookmarkedFreelancerDTO = new BookmarkedFreelancerDTO();
		bookmarkedFreelancerDTO.setBookmarkedBy(bookmarkedFreelancerDTO.getBookmarkedBy());
		bookmarkedFreelancerDTO.setFreelancer(bookmarkedFreelancer.getFreelancer());
		bookmarkedFreelancerDTO.setId(bookmarkedFreelancer.getId());
		bookmarkedFreelancerDTO.setSkill(bookmarkedFreelancer.getSkill());
		return bookmarkedFreelancerDTO;
	}

}
