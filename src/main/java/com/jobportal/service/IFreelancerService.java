package com.jobportal.service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.entity.Freelancer;
import com.jobportal.exception.JobPortalException;

public interface IFreelancerService 
{
	public FreelancerDTO save(Freelancer freelancer)throws JobPortalException;
	public FreelancerDTO findById(Long id)throws JobPortalException;
	public FreelancerDTO update(Freelancer freelancer)throws JobPortalException;
}
