package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.OnlineJobPortalSprint1Application;
import com.jobportal.dto.AdminDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Admin;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Feedback;
import com.jobportal.entity.Job;
import com.jobportal.entity.Recruiter;
import com.jobportal.exception.InvalidAdminException;
import com.jobportal.exception.InvalidRecruiterException;
import com.jobportal.repository.IAdminDao;
import com.jobportal.repository.IRecruiterDao;
import com.jobportal.service.IAdminService;
import com.jobportal.service.IAdminServiceImpl;
import com.jobportal.service.IRecruiterService;
import com.jobportal.service.IRecruiterServiceImpl;

@SpringBootTest(classes=OnlineJobPortalSprint1Application.class)
class AdminService_Tests {

	@InjectMocks
	private IAdminService iAdminService = new IAdminServiceImpl();
	
	@Mock
	private IAdminDao iAdminDao;
	
	@Mock
	IRecruiterDao iRecruiterDao;
	private Recruiter recruiter;
	
	@InjectMocks
	IRecruiterService iRecruiterService = new IRecruiterServiceImpl();
	
	
	@Test
	void adminAddTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		Mockito.when(iAdminDao.save(adminDTO.toAdmin())).thenReturn(adminDTO.toAdmin());
		AdminDTO actual = iAdminService.save(adminDTO);
		Assertions.assertEquals(actual, adminDTO);
		
	}
	@Test
	void adminUpdateTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		
		AdminDTO returnedAdminDTO = new AdminDTO() ;
		returnedAdminDTO.setId(1);
		returnedAdminDTO.setFirstName("John");
		returnedAdminDTO.setLastName("Jack");
		returnedAdminDTO.setPassword("2345");
		Optional <Admin> optional = Optional.of(returnedAdminDTO.toAdmin());
		Mockito.when(iAdminDao.findById(adminDTO.getId())).thenReturn(optional);
		AdminDTO actual = iAdminService.update(adminDTO);
		Assertions.assertEquals(adminDTO, actual);
		
	}
	
	@Test
	void failedAdminUpdateTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		Optional <Admin> optional = Optional.of(adminDTO.toAdmin());
		Mockito.when(iAdminDao.findById(adminDTO.getId())).thenReturn(optional);
		AdminDTO actual = iAdminService.update(adminDTO);
		InvalidAdminException exception = Assertions.assertThrows(InvalidAdminException.class,() -> iAdminService.update(adminDTO));
		Assertions.assertEquals("Service.ADMIN_NOT_FOUND", exception.getMessage());
		
	}
	
	@Test
	void findByIdTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		Optional <Admin> optional = Optional.of(adminDTO.toAdmin());
		Mockito.when(iAdminDao.findById(1)).thenReturn(optional);
		AdminDTO actual = iAdminService.update(adminDTO);
		Assertions.assertEquals(actual, adminDTO);
		
	}
	
	@Test
	void failedFindByIdTest() throws InvalidAdminException{

		Mockito.when(iAdminDao.findById(1)).thenReturn(null);
		InvalidAdminException exception = Assertions.assertThrows(InvalidAdminException.class,() -> iAdminService.findById(1));
		Assertions.assertEquals("Service.ADMIN_NOT_FOUND", exception.getMessage());
		
	}
	@Test
	void saveRecruiter() throws InvalidRecruiterException {
		//int id=1;
		RecruiterDTO recruiterDto = new RecruiterDTO();
		recruiterDto.setId(1);
		recruiterDto.setFirstName("Sri");
		recruiterDto.setLastName("Ram");
		Feedback feedback1 = new Feedback();
		Feedback feedback2 = new Feedback();
		Feedback feedback3 = new Feedback();
		List<Feedback> feedbacks= new ArrayList<>();
		Collections.addAll(feedbacks,feedback1,feedback2,feedback3);
		
		Job job1 = new Job();
		Job job2 = new Job();
		Job job3 = new Job();
		List<Job> jobs= new ArrayList<>();
		Collections.addAll(jobs,job1,job2,job3);
		
		BookmarkedFreelancer bm1 = new BookmarkedFreelancer();
		BookmarkedFreelancer bm2 = new BookmarkedFreelancer();
		BookmarkedFreelancer bm3 = new BookmarkedFreelancer();
		List<BookmarkedFreelancer> bms= new ArrayList<>();
		Collections.addAll(bms,bm1,bm2,bm3);
		recruiterDto.setPostedJobs(jobs);
		recruiterDto.setFeedbacks(feedbacks);
		recruiterDto.setPostedJobs(jobs);

		Mockito.when(iRecruiterDao.save(recruiterDto.toRecruiter())).thenReturn(recruiterDto.toRecruiter());
		RecruiterDTO actual = iRecruiterService.save(recruiterDto);
		Assertions.assertEquals(recruiterDto, actual);
	}
	
	@Test
	void findByIdTestR() throws InvalidRecruiterException{
		RecruiterDTO recruiterDTO = new RecruiterDTO();
		recruiterDTO.setId(1);
		recruiterDTO.setFirstName("Sri");
		recruiterDTO.setLastName("Ram");
		Optional<Recruiter> optional = Optional.of(recruiterDTO.toRecruiter());
		Mockito.when(iRecruiterDao.findById(1)).thenReturn(optional);
		RecruiterDTO actual = iRecruiterService.update(recruiterDTO);
		Assertions.assertEquals(actual, recruiterDTO);
		
	}
	
	@Test
	void failedFindByIdTestR() throws InvalidRecruiterException{
		Mockito.when(iRecruiterDao.findById(1)).thenReturn(null);
		InvalidRecruiterException exception = Assertions.assertThrows(InvalidRecruiterException.class,() -> iRecruiterService.findById(1));
		Assertions.assertEquals("Service.RECRUITER_NOT_FOUND", exception.getMessage());
		
	}
	
	@Test
	void adminUpdateTestR() throws InvalidRecruiterException{
		RecruiterDTO recruiterDTO = new RecruiterDTO();
		recruiterDTO.setId(1);
		recruiterDTO.setFirstName("Sri");
		recruiterDTO.setLastName("Ram");
		RecruiterDTO returnedRecruiterDTO = new RecruiterDTO() ;
		returnedRecruiterDTO.setId(1);
		returnedRecruiterDTO.setFirstName("Sri");
		returnedRecruiterDTO.setLastName("Krishna");
		Optional <Recruiter> optional = Optional.of(returnedRecruiterDTO.toRecruiter());
		Mockito.when(iRecruiterDao.findById(recruiterDTO.getId())).thenReturn(optional);
		RecruiterDTO actual = iRecruiterService.update(recruiterDTO);
		Assertions.assertEquals(recruiterDTO, actual);
		
	}
	@Test
	void failedAdminUpdateTestR() throws InvalidRecruiterException{
		RecruiterDTO recruiterDTO = new RecruiterDTO();
		recruiterDTO.setId(1);
		recruiterDTO.setFirstName("Sri");
		recruiterDTO.setLastName("Ram");
		Optional <Recruiter> optional = Optional.of(recruiterDTO.toRecruiter());
		Mockito.when(iRecruiterDao.findById(recruiterDTO.getId())).thenReturn(optional);
		RecruiterDTO actual = iRecruiterService.update(recruiterDTO);
		InvalidRecruiterException exception = Assertions.assertThrows(InvalidRecruiterException.class,() -> iRecruiterService.update(recruiterDTO));
		Assertions.assertEquals("Service.RECRUITER_NOT_FOUND", exception.getMessage());
		
	}

}
