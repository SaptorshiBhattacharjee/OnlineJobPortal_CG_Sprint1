package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Skill;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.IBookmarkedFreelancerDao;

public class IBookmarkFreelancerServiceImpl implements IBookmarkFreelancerService {
	
	@Autowired
	IBookmarkedFreelancerDao iBookmarkedFreelancerDao;
	
	@Override
	public BookmarkedFreelancerDTO bookmarkFreelancer(FreelancerDTO freelancerDTO, SkillDTO skillDTO,
			RecruiterDTO recruiterDTO) throws Exception {
		
	}

	@Override
	public List<BookmarkedFreelancerDTO> findBookmarkedFreelancerBySkill(SkillDTO skillDTO, RecruiterDTO recruiterDTO)
			throws Exception {
		
		for(BookmarkedFreelancer)
	}

	@Override
	public void removeBookmarkedFreelancer(FreelancerDTO freelancerDTO, SkillDTO skillDTO, RecruiterDTO recruiterDTO)
			throws JobPortalException {
		
		
		Integer count = iBookmarkedFreelancerDao.removeBookmarkedFreelancer(freelancerDTO.getId(), skillDTO.getId(), recruiterDTO.getId());
		if(count == 0) {
			throw new JobPortalException("Service.NOT_FOUND");
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
