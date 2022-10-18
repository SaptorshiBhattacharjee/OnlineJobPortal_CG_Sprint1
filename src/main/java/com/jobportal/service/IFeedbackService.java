package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.FeedbackDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.exception.InvalidFeedbackException;


public interface IFeedbackService {
	
	public FeedbackDTO createFeedback(RecruiterDTO recruiterDTO,FreelancerDTO freelancerDTO,int rating,String review) throws InvalidFeedbackException;
	public int averageRating(FreelancerDTO freelancerDTO) throws InvalidFeedbackException;
	public FeedbackDTO findFeedbacksByFreelancer(FreelancerDTO freelancerDTO) throws InvalidFeedbackException;

}
