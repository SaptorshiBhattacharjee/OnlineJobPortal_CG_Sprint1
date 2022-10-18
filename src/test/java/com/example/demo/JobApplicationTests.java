package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import com.jobportal.service.IJobApplicationService;
import com.jobportal.service.IJobApplicationServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.OnlineJobPortalSprint1Application;
import com.jobportal.dto.JobDTO;
import com.jobportal.exception.InvalidJobApplicationException;
import com.jobportal.repository.IJobApplicationDao;

@SpringBootTest(classes=OnlineJobPortalSprint1Application.class)
class JobApplicationTests {
	
	@Mock
	IJobApplicationDao iJobApplicationDao;
	
	@InjectMocks
	IJobApplicationService iJobApplicationService = new IJobApplicationServiceImpl();
	
	@Test
	void applyToJobTest() throws InvalidJobApplicationException{
		JobDTO jobDTO = new JobDTO();
		
	}
	

}
