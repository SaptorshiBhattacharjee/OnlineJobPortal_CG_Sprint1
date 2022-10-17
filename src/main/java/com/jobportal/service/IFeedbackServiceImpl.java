package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.FeedbackDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Recruiter;
import com.jobportal.exception.InvalidFeedbackException;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.IFeedbackDao;
import com.jobportal.repository.IFreelancerDao;
import com.jobportal.repository.IRecruiterDao;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService{
	
	@Autowired
	IFeedbackDao ifeedbackDao;
	@Autowired
	IRecruiterDao irecruiterDao;

	@Autowired
	IFreelancerDao ifreelancerDao;

	@Override
	public FeedbackDTO createFeedback(RecruiterDTO recruiterDTO, FreelancerDTO freelancerDTO, int rating, String review)
			throws InvalidFeedbackException {	
		Feedback feedback = new Feedback();
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		Recruiter recruiter = new Recruiter();
		Freelancer freelancer = new Freelancer();
		
		recruiter.setId(recruiterDTO.getId());
		freelancer.setId(freelancerDTO.getId());
		
		feedback.setCreatedBy(recruiter);
		feedback.setCreatedFor(freelancer);
		feedback.setComment(review);
		feedback.setRating(rating);
		ifeedbackDao.save(feedback);
		
		feedbackDTO.setCreatedBy(recruiter);
		feedbackDTO.setCreatedFor(freelancer);
		feedbackDTO.setComment(review);
		feedbackDTO.setRating(rating);
		
		return feedbackDTO;
		
	}

	@Override
	public int averageRating(FreelancerDTO freelancerDTO) throws InvalidFeedbackException {
		Optional<Feedback> optional = ifeedbackDao.findById(freelancerDTO.getId());
		List<Integer> ratings= new ArrayList<Integer>();
		Feedback feedback = optional.orElseThrow(()->new InvalidFeedbackException("Service.NO_RATINGS_AVAILABLE"));
		ratings.add(feedback.getRating());
		int sum = 0;
		for(int i=0;i<ratings.size();i++) {
			sum=sum+i;
		}
		return sum/ratings.size() ;

}

	@Override
	public List<FeedbackDTO> findFeedbacksByFreelancer(FreelancerDTO freelancerDTO) throws InvalidFeedbackException {
		Optional<Freelancer> optional = ifreelancerDao.findById(freelancerDTO.getId());
		Freelancer freelancer = optional.orElseThrow(()->new InvalidFeedbackException("Service.NO_FEEDBACKS_FOR_THIS_FREELANCER"));
		freelancer.setId(freelancerDTO.getId());
		List<Feedback> feedbackByFreelancer = ifeedbackDao.findFeedbacksByFreelancer(freelancer);
		List<FeedbackDTO> feedbackByFreelancerDTO = new ArrayList<>();
		for(Feedback feedback : feedbackByFreelancer) {
			FeedbackDTO feedbackDTO = new FeedbackDTO();
			feedbackDTO.setId(feedback.getId());
			feedbackDTO.setComment(feedback.getComment());
			feedbackDTO.setCreatedBy(feedback.getCreatedBy());
			feedbackDTO.setCreatedFor(feedback.getCreatedFor());
			feedbackDTO.setRating(feedback.getRating());
			
			
			feedbackByFreelancerDTO.add(feedbackDTO);
		}
		return feedbackByFreelancerDTO;
		
	}

}
