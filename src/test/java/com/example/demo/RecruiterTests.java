package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.base.Optional;
import com.jobportal.OnlineJobPortalSprint1Application;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Recruiter;
import com.jobportal.repository.IRecruiterDao;
import com.jobportal.service.IRecruiterService;
import com.jobportal.service.IRecruiterServiceImpl;

@SpringBootTest(classes = OnlineJobPortalSprint1Application.class)
public class RecruiterTests {
	
	@Mock
	IRecruiterDao iRecruiterDao;
	private Recruiter recruiter;
	
	@InjectMocks
	IRecruiterService iRecruiterService = new IRecruiterServiceImpl();
	
	@BeforeEach
	void setUp() {
		//recruiter = new Recruiter();
//		Feedback feedback1 = new Feedback();
//		Feedback feedback2 = new Feedback();
//		Feedback feedback3 = new Feedback();
//		List<Feedback> feedbacks= new ArrayList<>();
//		Collections.addAll(feedbacks,feedback1,feedback2,feedback3);
//		recruiter.setFeedbacks(feedbacks);

		recruiter.setId(1);
		recruiter.setFirstName("Sri");
		recruiter.setLastName("Ram");
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	void saveRecruiter() {
		int id=1;
		Mockito.when(iRecruiterDao.findById((id)).thenReturn(Optional.of(recruiter)));
		RecruiterDTO expectedRecruiterDto = new RecruiterDTO(1,"Sri","Ram",null,null,null);
		RecruiterDTO actualAppointmentDto = iRecruiterService.save(recruiterDto);
	}

}
