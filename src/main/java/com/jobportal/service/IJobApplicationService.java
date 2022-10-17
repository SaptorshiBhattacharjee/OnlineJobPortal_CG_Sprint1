
package com.jobportal.service;
 

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.exception.JobPortalException;


public interface IJobApplicationService {

	public JobApplicationDTO applyToJob(JobDTO jobDTO, String coverletter, FreelancerDTO freelancerDTO) throws JobPortalException;
	
	public JobApplicationDTO updateJobApplication(JobDTO jobDTO, String coverLetter, FreelancerDTO freelancerDTO) throws JobPortalException;
	
	public void remove(JobDTO jobDTO, FreelancerDTO freelancerDTO) throws JobPortalException;
	
	public JobApplicationDTO findById(int id) throws JobPortalException;
}

