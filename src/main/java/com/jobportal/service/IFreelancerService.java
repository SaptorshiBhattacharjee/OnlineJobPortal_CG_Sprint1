package com.jobportal.service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.entity.Freelancer;
import com.jobportal.exception.OnlineJobPortalException;

public interface IFreelancerService 
{
	public FreelancerDTO save(Freelancer freelancer)throws OnlineJobPortalException;
	public FreelancerDTO findById(Long id)throws OnlineJobPortalException;
	public FreelancerDTO update(Freelancer freelancer)throws OnlineJobPortalException;
}
