package com.jobportal.service;

import java.util.List;


import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.exception.InvalidBookmarkedFreelancerException;



public interface IBookmarkFreelancerService {
	
	public BookmarkedFreelancerDTO bookmarkFreelancer(FreelancerDTO freelancerDTO, SkillDTO skillDTO, RecruiterDTO recruiterDTO) throws InvalidBookmarkedFreelancerException;
	public List<BookmarkedFreelancerDTO> findBookmarkedFreelancerBySkill(SkillDTO skillDTO, RecruiterDTO recruiterDTO)throws InvalidBookmarkedFreelancerException;
	public void removeBookmarkedFreelancer(FreelancerDTO freelancerDTO, SkillDTO skillDTO, RecruiterDTO recruiterDTO) throws InvalidBookmarkedFreelancerException;
	public BookmarkedFreelancerDTO findById(int id) throws InvalidBookmarkedFreelancerException;
}
