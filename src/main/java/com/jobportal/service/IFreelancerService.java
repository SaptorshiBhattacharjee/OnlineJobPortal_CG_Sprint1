package com.jobportal.service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.entity.Freelancer;
import com.jobportal.exception.JobPortalException;

public interface IFreelancerService 
{
<<<<<<< HEAD
	public FreelancerDTO save(FreelancerDTO freelancerDTO)throws JobPortalException;
	public FreelancerDTO findById(Integer id)throws JobPortalException;
	public FreelancerDTO update(FreelancerDTO freelancerDTO)throws JobPortalException;
=======
	public FreelancerDTO save(Freelancer freelancer)throws JobPortalException;
	public FreelancerDTO findById(Long id)throws JobPortalException;
	public FreelancerDTO update(Freelancer freelancer)throws JobPortalException;
>>>>>>> branch 'main' of https://github.com/SaptorshiBhattacharjee/OnlineJobPortal_CG_Sprint1.git
}
