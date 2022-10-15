package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.exception.JobPortalException;


public interface IBookmarkFreelancerService {
	
	public BookmarkedFreelancerDTO bookmarkFreelancer(FreelancerDTO freelancerDTO,SkillDTO skillDTO,RecruiterDTO recruiterDTO) throws JobPortalException;
	public List<BookmarkedFreelancerDTO> findBookmarkedFreelancerBySkill(SkillDTO skillDTO,RecruiterDTO recruiterDTO)throws JobPortalException;
	public void removeBookmarkedFreelancer(FreelancerDTO freelancerDTO,SkillDTO skillDTO,RecruiterDTO recruiterDTO) throws JobPortalException;
	public BookmarkedFreelancerDTO findById(int id) throws JobPortalException;
}
