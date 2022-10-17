package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.dto.FeedbackDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Feedback;
import com.jobportal.exception.InvalidRecruiterException;
import com.jobportal.repository.IRecruiterDao;
import com.jobportal.service.IRecruiterService;
import com.jobportal.service.IRecruiterServiceImpl;

@SpringBootTest
class OnlineJobPortalSprint1ApplicationTests {
	
	@Mock
	IRecruiterDao iRecruiterDao;
	
	@InjectMocks
	IRecruiterService iRecruiterService = new IRecruiterServiceImpl();

	@Test
	void saveRecruiter() throws InvalidRecruiterException{
		RecruiterDTO recruiterDto = new RecruiterDTO();
		Feedback feedback1 = new Feedback();
		Feedback feedback2 = new Feedback();
		Feedback feedback3 = new Feedback();
		List<Feedback> feedbacks= new ArrayList<>();
		Collections.addAll(feedbacks,feedback1,feedback2,feedback3);
		recruiterDto.setFirstName("Sri");
		recruiterDto.setLastName("Ram");
		recruiterDto.setFeedbacks(feedbacks);
		
	}

}
