
package com.jobportal.service;
 

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;


public interface IJobApplicationService {

	public JobApplicationDTO applyToJob(JobDTO jobDTO, String coverletter, FreelancerDTO freelancerDTO) throws Exception;
	
	public JobApplicationDTO updateJobApplication(JobDTO jobDTO, String coverLetter, FreelancerDTO freelancerDTO) throws Exception;
	
	public void remove(JobDTO jobDTO, FreelancerDTO freelancerDTO) throws Exception;
	
	public JobApplicationDTO findById(int id) throws Exception;
}

