
package com.jobportal.service;
 

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.exception.InvalidJobApplicationException;



public interface IJobApplicationService {

	public JobApplicationDTO applyToJob(JobDTO jobDTO, String coverletter, FreelancerDTO freelancerDTO) throws InvalidJobApplicationException;
	
	public JobApplicationDTO updateJobApplication(JobDTO jobDTO, String coverLetter, FreelancerDTO freelancerDTO) throws InvalidJobApplicationException;
	
	public void remove(JobDTO jobDTO, FreelancerDTO freelancerDTO) throws InvalidJobApplicationException;

	public JobApplicationDTO findById(int id) throws InvalidJobApplicationException;
}

