package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.FeedbackDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;


public interface IFeedbackService {
	
	public FeedbackDTO createFeedback(RecruiterDTO recruiterDTO,FreelancerDTO freelancerDTO,int rating,String review) throws Exception;
	public int averageRating(FreelancerDTO freelancerDTO) throws Exception;
	public List<FeedbackDTO> findFeedbacksByFreelancer(FreelancerDTO freelancerDTO) throws Exception;

}
