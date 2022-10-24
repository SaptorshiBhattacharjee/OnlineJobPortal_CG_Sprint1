
package com.jobportal.service;
 

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.exception.InvalidJobApplicationException;



public interface IJobApplicationService {

	public boolean applyToJob(int jobId, String coverletter, int freelancerId) throws Exception;
	
	public boolean updateJobApplication(int jobDId, String coverLetter, int freelancerId) throws Exception;
	
	public boolean remove(int jobId, int freelancerId) throws Exception;

	public JobApplicationDTO findById(int id) throws Exception;
}

