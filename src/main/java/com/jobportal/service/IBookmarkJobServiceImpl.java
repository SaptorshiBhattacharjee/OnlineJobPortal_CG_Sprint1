package com.jobportal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.BookmarkedJobDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.entity.BookmarkedJob;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.Skill;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.IBookmarkedFreelancerDao;
import com.jobportal.repository.IBookmarkedJobDao;

@Service(value = "iBookmarkJobService")
@Transactional
public class IBookmarkJobServiceImpl implements IBookmarkJobService
{
	@Autowired
	IBookmarkedJobDao iBookMarkedJobDao;

	@Override
	public BookmarkedJob bookmarkJob(Job job, Freelancer freelancer) throws JobPortalException 
	{
		
		return null;
	}

	@Override
	public void removeBookmark(Job job, Freelancer freelancer) throws JobPortalException 
	{
		
	}

	@Override
	public List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill, Freelancer freelancer) throws JobPortalException 
	{
		return null;
	}

	@Override
	public BookmarkedJob findById(Integer id) throws JobPortalException 
	{
		Optional<BookmarkedJob> op1 = iBookMarkedJobDao.findById(id);
		BookmarkedJob bookmarkedJob = op1.orElseThrow(() -> new JobPortalException("Service.BOOKMARKED_JOB_NOT_FOUND"));
		
		//adding data to the DTO by id
		BookmarkedJobDTO bookmarkedJobDTO = new BookmarkedJobDTO();
		bookmarkedJob.setId(bookmarkedJobDTO.getId());
		bookmarkedJob.setSkill(bookmarkedJobDTO.getSkill());
		bookmarkedJob.setJob(bookmarkedJobDTO.getJob());
		bookmarkedJob.setFreelancer(bookmarkedJobDTO.getFreelancer());
		
		return bookmarkedJob;
	}
}
