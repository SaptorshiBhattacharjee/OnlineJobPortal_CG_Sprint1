package com.example.demo;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import com.jobportal.OnlineJobPortalSprint1Application;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Job;
import com.jobportal.entity.Recruiter;
import com.jobportal.exception.InvalidRecruiterException;
import com.jobportal.repository.IRecruiterDao;
import com.jobportal.service.IRecruiterService;
import com.jobportal.service.IRecruiterServiceImpl;

@SpringBootTest(classes = OnlineJobPortalSprint1Application.class)
class OnlineJobPortalSprint1ApplicationTests {

	@Mock
	IRecruiterDao iRecruiterDao;

	@InjectMocks
	IRecruiterService iRecruiterService = new IRecruiterServiceImpl();

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Test void saveRecruiter() throws InvalidRecruiterException{ RecruiterDTO
	 * recruiterDto = new RecruiterDTO(); Feedback feedback1 = new Feedback();
	 * Feedback feedback2 = new Feedback(); Feedback feedback3 = new Feedback();
	 * List<Feedback> feedbacks= new ArrayList<>();
	 * Collections.addAll(feedbacks,feedback1,feedback2,feedback3);
	 * recruiterDto.setFirstName("Sri"); recruiterDto.setLastName("Ram");
	 * recruiterDto.setFeedbacks(feedbacks); BookmarkedFreelancer
	 * bookmarkedfreelancer1 = new BookmarkedFreelancer(); BookmarkedFreelancer
	 * bookmarkedfreelancer2 = new BookmarkedFreelancer(); BookmarkedFreelancer
	 * bookmarkedfreelancer3 = new BookmarkedFreelancer();
	 * List<BookmarkedFreelancer> bmFreelancers= new ArrayList<>();
	 * Collections.addAll(bmFreelancers,bookmarkedfreelancer1,bookmarkedfreelancer2,
	 * bookmarkedfreelancer3); recruiterDto.setFreelancers(bmFreelancers); Job job1
	 * = new Job(); Job job2 = new Job(); Job job3 = new Job(); List<Job> jobs = new
	 * ArrayList<>(); Collections.addAll(jobs, job1,job2,job3);
	 * recruiterDto.setPostedJobs(jobs); //recruiterDto.setId(1);
	 * IRecruiterServiceImpl irecruiterserviceimpl = new IRecruiterServiceImpl();
	 * RecruiterDTO expectedDto = irecruiterserviceimpl.save(recruiterDto);
	 * assertNotNull(expectedDto); //when(((CrudRepository<Recruiter, Integer>)
	 * recruiterDto).save(Mockito.any(Recruiter.class))).thenAnswer(i ->
	 * i.getArguments()[0]);
	 * 
	 * }
	 */
	

}
