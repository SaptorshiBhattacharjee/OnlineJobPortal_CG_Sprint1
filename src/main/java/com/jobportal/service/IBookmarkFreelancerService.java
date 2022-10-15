package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;


public interface IBookmarkFreelancerService {
	
	public BookmarkedFreelancerDTO bookmarkFreelancer(FreelancerDTO freelancerDTO,SkillDTO skillDTO,RecruiterDTO recruiterDTO) throws Exception;
	public List<BookmarkedFreelancerDTO> findBookmarkedFreelancerBySkill(SkillDTO skillDTO,RecruiterDTO recruiterDTO)throws Exception;
	public void removeBookmarkedFreelancer(FreelancerDTO freelancer,SkillDTO skill,RecruiterDTO recruiterDTO) throws Exception;
	public BookmarkedFreelancerDTO findById(long id) throws Exception;
}
