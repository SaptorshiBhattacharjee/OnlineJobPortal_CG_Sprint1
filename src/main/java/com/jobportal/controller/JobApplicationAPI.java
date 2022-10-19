
package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.AdminDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.exception.InvalidJobApplicationException;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.IAdminService;
import com.jobportal.service.IFreelancerService;
import com.jobportal.service.IJobApplicationService;
import com.jobportal.service.IJobService;

@RestController
@RequestMapping(value="/jobportal/jobapplication")
public class JobApplicationAPI {
	
	@Autowired
	private IJobApplicationService iJobApplicationService;
	
	@Autowired
	private IFreelancerService iFreelancerService;
	
	@Autowired
	private IJobService iJobService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/applytojob")

	public ResponseEntity<String> applyToJob(@RequestBody int jobId, String coverLetter, int freelancerId) throws InvalidJobApplicationException, JobPortalException{
		JobDTO jobDTO = iJobService.findById(jobId);
		FreelancerDTO freelancerDTO = iFreelancerService.findById(freelancerId);
		JobApplicationDTO Applied = iJobApplicationService.applyToJob(jobDTO, coverLetter, freelancerDTO);
		String successMessage = environment.getProperty("API.APPLIED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value="/updatejobapplication")
	public ResponseEntity<String> updateJobApplication(@RequestBody JobDTO jobDTO, String coverLetter, FreelancerDTO freelancerDTO) throws InvalidJobApplicationException{
		JobApplicationDTO updateTo = iJobApplicationService.updateJobApplication(jobDTO, coverLetter, freelancerDTO);
		String successMessage = environment.getProperty("API.UPDATED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete")

	public ResponseEntity<String> remove(@RequestBody JobDTO jobDTO, FreelancerDTO freelancerDTO) throws InvalidJobApplicationException{
		iJobApplicationService.remove(jobDTO, freelancerDTO);
		String successMessage = environment.getProperty("API.REMOVED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/findbyid/{jobApplicationId}")
	public ResponseEntity<JobApplicationDTO> findById(@PathVariable int jobApplicationId) throws InvalidJobApplicationException{
		JobApplicationDTO jobApplication = iJobApplicationService.findById(jobApplicationId);
		return new ResponseEntity<>(jobApplication, HttpStatus.OK);
	}
	
}
