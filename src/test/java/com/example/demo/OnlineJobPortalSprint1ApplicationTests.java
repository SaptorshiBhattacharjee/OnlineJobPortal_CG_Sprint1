package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.dto.FeedbackDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobApplication;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.exception.InvalidJobException;
import com.jobportal.exception.InvalidRecruiterException;
import com.jobportal.repository.IJobDao;
import com.jobportal.repository.IRecruiterDao;
import com.jobportal.service.IJobService;
import com.jobportal.service.IJobServiceImpl;
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
	@Mock
	IJobDao ijobdao;
	
	@InjectMocks
	IJobService ijobservice = new IJobServiceImpl();
	@Test
	void postjobValidTests()throws InvalidJobException {
		Skill skill = new Skill();
		skill.setId(201);
		Recruiter recruit = new Recruiter();
		recruit.setId(301);
		JobDTO jobdto = new JobDTO();
        List<JobApplication> jobApplications = jobdto.getJobApplications();
        Freelancer freelancer = new Freelancer();
        Recruiter recruiter = new Recruiter();
        jobdto.setId(jobdto.getId());
        jobdto.setSkill(skill);
        jobdto.setPostedBy(recruiter);
		jobdto.setPostedDate(LocalDate.now());
        jobdto.setAwardedTo(freelancer);
        jobdto.setActive(true);
        jobdto.setJobApplications(jobApplications);
        Job j = jobdto.toJob();
        assertEquals(1,ijobdao.save(j));
       
}
	@Test
	void setup() {
		Job job = new Job();
		job.setId(1);
		job.setPostedDate(LocalDate.now());
		Boolean active = true;
		job.setActive(active);
		Skill skill = new Skill(1,"Java","Description of java");
		job.setSkill(skill);
		
		Recruiter recruiter = new Recruiter();
		Feedback feedback1 = new Feedback();
		Feedback feedback2 = new Feedback();
		Feedback feedback3 = new Feedback();
		List<Feedback> feedbacks= new ArrayList<>();
		Collections.addAll(feedbacks,feedback1,feedback2,feedback3);
		recruiter.setFirstName("Sri");
		recruiter.setLastName("Ram");
		recruiter.setFeedbacks(feedbacks);
		job.setPostedBy(recruiter);
		
		JobApplication jobapplication1 = new JobApplication();
		JobApplication jobapplication2 = new JobApplication(); 
		JobApplication jobapplication3 = new JobApplication(); 
		List<JobApplication> jobapplication = new ArrayList<>();
		Collections.addAll(jobapplication,jobapplication1,jobapplication2,jobapplication3);
		job.setJobApplications(jobapplication);
	
		Freelancer freelancer = new Freelancer();
		freelancer.setId(1);
		freelancer.setFirstName("Mani");
		freelancer.setLastName("Korada");
		freelancer.setPassword("sita123");
		freelancer.setAppliedJobs(jobapplication);
		freelancer.setFeedbacks(feedbacks);
		//freelancer.setBookmarkedJobs(null);
		
		
		//job.set
	}
//	
//	void findByIdTests() throws InvalidJobException{
//	
//	   int id = 1;
//	   Mockito.when(ijobdao.findById(id)).thenReturn(Optional.of(null));
//	   JobDTO expectedjobdto = new JobDTO(1,);
//	   JobDTO actualjobdto = ijobservice.findById(id);
//	   Assertions.assertEquals(expectedjobdto, actualjobdto);
//	   
//	}
	
	
	

}
