package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.service.IJobApplicationService;
import com.jobportal.service.IJobApplicationServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.OnlineJobPortalSprint1Application;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobApplication;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.exception.InvalidJobApplicationException;
import com.jobportal.repository.IJobApplicationDao;

@SpringBootTest(classes=OnlineJobPortalSprint1Application.class)
class JobApplicationTests {
	
	@Mock
	IJobApplicationDao iJobApplicationDao;
	
	@InjectMocks
	IJobApplicationService iJobApplicationService = new IJobApplicationServiceImpl();
	
	@BeforeEach
	void setup() {
		
		Skill skill = new Skill();
		skill.setId(11);
		Recruiter recruiter = new Recruiter();
		recruiter.setId(101);
		
		Freelancer freelancer = new Freelancer();
		JobDTO jobDTO = new JobDTO();
		jobDTO.setId(1);
		jobDTO.setSkill(skill);
		jobDTO.setPostedBy(recruiter);
		jobDTO.setPostedDate(LocalDate.now());
		jobDTO.setAwardedTo(freelancer);
		jobDTO.setJobApplications(null);
		jobDTO.setActive(true);
		
		List<JobApplication> applications = new ArrayList<>();
		freelancer.setAppliedJobs(applications);
		JobApplication jobApplication1 = new JobApplication();
		jobApplication1.setAppliedDate(LocalDateTime.now());
		jobApplication1.setId(1);
		jobApplication1.setCoverLetter("Applicant 1");
		jobApplication1.setJob(jobDTO.toJob());
		
		JobApplication jobApplication2 = new JobApplication();
		jobApplication2.setAppliedDate(LocalDateTime.now());
		jobApplication2.setId(2);
		jobApplication2.setCoverLetter("Applicant 2");
		jobApplication2.setJob(jobDTO.toJob());
		
		JobApplication jobApplication3 = new JobApplication();
		jobApplication3.setAppliedDate(LocalDateTime.now());
		jobApplication3.setId(1);
		jobApplication3.setCoverLetter("Applicant 1");
		jobApplication3.setJob(jobDTO.toJob());
	}
	
//	@Test
//	void applyToJobTest() throws InvalidJobApplicationException{
//		JobApplication jobApplication = new JobApplication();
//		jobApplication.setJob(job);
//		jobApplication.setAppliedDate(LocalDateTime.now());
//		jobApplication.setCoverLetter("Applicant 4");
//		Mockito.when(iJobApplicationDao.save(jobApplication)).thenReturn(jobApplication);
//		JobApplicationDTO actual =iJobApplicationService.applyToJob(job.toJobDTO(), "Applicant 4",freelancer.toFreelancerDTO());
//		JobApplicationDTO jobApplicationDTO = jobApplication.toJobApplicationDTO();
//		Assertions.assertEquals(actual, jobApplicationDTO);
//	}
	
//	@Test
//	void applyToJobTest() throws InvalidJobApplicationException{
//		JobApplication jobApplication = new JobApplication(3, job.toJobDTO(), LocalDateTime.now(),"Applicant 4");
//		Mockito.when(iJobApplicationDao.save(jobApplication)).thenReturn(jobApplication);
//		JobApplicationDTO actual =iJobApplicationService.applyToJob(job.toJobDTO(), "Applicant 4",freelancer.toFreelancerDTO());
//		JobApplicationDTO jobApplicationDTO = jobApplication.toJobApplicationDTO();
//		Assertions.assertEquals(actual, jobApplicationDTO);
//	}

}
