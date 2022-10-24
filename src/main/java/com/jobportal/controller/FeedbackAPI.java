package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.FeedbackDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.service.IFeedbackService;

@RestController
@RequestMapping(value="/jobportal/recruiter")
public class FeedbackAPI {
	
	@Autowired
	private IFeedbackService iFeedbackService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/createfeedback")
	public ResponseEntity<String> applyToJob(@RequestBody  int rating, String review) throws Exception{
		FeedbackDTO feedback = iFeedbackService.createFeedback(rating,review);
		String successMessage=environment.getProperty("API.FEEDBACK_CREATED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/averagerating")
	public ResponseEntity<Integer> averageRating(@RequestBody FreelancerDTO freelancerDTO) throws Exception{
		int average  = iFeedbackService.averageRating(freelancerDTO);
		return new ResponseEntity<>(average, HttpStatus.OK);
	}
	@GetMapping(value="/findfeedbacksbyfreelancer")
	public ResponseEntity<List<FeedbackDTO>> findFeedbacksByFreelancer(@RequestBody FreelancerDTO freelancerDTO) throws Exception{
		List<FeedbackDTO> feedbackList = iFeedbackService.findFeedbacksByFreelancer(freelancerDTO);
		return new ResponseEntity<List<FeedbackDTO>>(feedbackList, HttpStatus.OK);
	}

}
