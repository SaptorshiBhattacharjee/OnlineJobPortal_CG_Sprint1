package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.exception.InvalidBookmarkedFreelancerException;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.IBookmarkFreelancerService;
import com.jobportal.service.IJobApplicationService;

@RestController
@RequestMapping("value=/jobportal/jobapplication")
public class BookmarkedFreelancerAPI {
	
	@Autowired
	private IBookmarkFreelancerService iBookmarkFreelancerService;
	
	@Autowired
	Environment environment;
	
	
	@PostMapping(value="/bookmarkfreelancer")
	public ResponseEntity<String> applyToJob(@RequestBody FreelancerDTO freelancerDTO, SkillDTO skillDTO, RecruiterDTO recruiterDTO) throws InvalidBookmarkedFreelancerException{
		BookmarkedFreelancerDTO bookmarked = iBookmarkFreelancerService.bookmarkFreelancer(freelancerDTO, skillDTO, recruiterDTO);
		String successMessage = environment.getProperty("API.APPLIED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@GetMapping(value="/findbookmarkedfreelancerbyskill")

	public ResponseEntity<List<BookmarkedFreelancerDTO>> findBookmarkedFreelancerBySkill(@RequestBody SkillDTO skillDTO, RecruiterDTO recruiterDTO) throws InvalidBookmarkedFreelancerException{
		List<BookmarkedFreelancerDTO> list = iBookmarkFreelancerService.findBookmarkedFreelancerBySkill(skillDTO, recruiterDTO);
		return new ResponseEntity<List<BookmarkedFreelancerDTO>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/removeBookmarkedFreelancer")

	public ResponseEntity<String> remove(@RequestBody FreelancerDTO freelancerDTO,SkillDTO skillDTO,RecruiterDTO recruiterDTO) throws InvalidBookmarkedFreelancerException{
		iBookmarkFreelancerService.removeBookmarkedFreelancer(freelancerDTO, skillDTO, recruiterDTO);
		String successMessage = environment.getProperty("API.REMOVED_SUCCESSFULLY");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/findbyid/{bookmarkedFreelancerId}")

	public ResponseEntity<BookmarkedFreelancerDTO> findById(@PathVariable int bookmarkedFreelancerId) throws InvalidBookmarkedFreelancerException{
		BookmarkedFreelancerDTO bookmarkedFreelancerDTO = iBookmarkFreelancerService.findById(bookmarkedFreelancerId);
		return new ResponseEntity<BookmarkedFreelancerDTO>(bookmarkedFreelancerDTO, HttpStatus.OK);
	}
	
}
