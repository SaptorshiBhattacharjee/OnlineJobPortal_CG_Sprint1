package com.jobportal.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Recruiter;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.IRecruiterDao;


@Service(value="iRecruiterService")
@Transactional
public class IRecruiterServiceImpl implements IRecruiterService{
	
	@Autowired
	IRecruiterDao irecruiterDao;
	
	@Override
	public RecruiterDTO save(RecruiterDTO recruiterDTO) throws JobPortalException {
		Recruiter recruiter = new Recruiter();
		recruiter.setFirstName(recruiterDTO.getFirstName());
		recruiter.setLastName(recruiterDTO.getLastName());
		recruiter.setPostedJobs(recruiterDTO.getPostedJobs());
		recruiter.setFeedbacks(recruiterDTO.getFeedbacks());
		recruiter.setFreelancers(recruiterDTO.getFreelancers());
		if(!(recruiterDTO.getFirstName()==null || recruiterDTO.getLastName()==null ||recruiterDTO.getFeedbacks()==null ||recruiterDTO.getFreelancers()==null || recruiterDTO.getPostedJobs()==null)) {
			irecruiterDao.save(recruiter);
			return recruiterDTO;
		}
		else {
			throw new JobPortalException("Service.RECRUITER_ALREADY_EXISTS");
		}
		
		
	}
	@Override
	public RecruiterDTO findById(Integer id) throws JobPortalException{
		Optional<Recruiter> optional = irecruiterDao.findById(id);
		Recruiter recruiter = optional.orElseThrow(() -> new JobPortalException("Service.RECRUITER_NOT_FOUND_WITH_ID"));
		RecruiterDTO recruiterDTO = new RecruiterDTO();
		recruiterDTO.setId(recruiter.getId());
		recruiterDTO.setFirstName(recruiter.getFirstName());
		recruiterDTO.setLastName(recruiter.getLastName());
		recruiterDTO.setFeedbacks(recruiter.getFeedbacks());
		recruiterDTO.setFreelancers(recruiter.getFreelancers());
		recruiterDTO.setPostedJobs(recruiter.getPostedJobs());
		return recruiterDTO;
		
	}
	@Override
	public RecruiterDTO update(RecruiterDTO recruiterDTO) throws JobPortalException{
		Optional<Recruiter> optional = irecruiterDao.findById(recruiterDTO.getId());
		Recruiter recruiter1 = optional.orElseThrow(() -> new JobPortalException("Service.RECRUITER_NOT_FOUND"));
		recruiter1.setFirstName(recruiterDTO.getFirstName());
		recruiter1.setLastName(recruiterDTO.getLastName());
		recruiter1.setFeedbacks(recruiterDTO.getFeedbacks());
		recruiter1.setFreelancers(recruiterDTO.getFreelancers());
		recruiter1.setPostedJobs(recruiterDTO.getPostedJobs());
		return recruiterDTO;
		
	}


}
