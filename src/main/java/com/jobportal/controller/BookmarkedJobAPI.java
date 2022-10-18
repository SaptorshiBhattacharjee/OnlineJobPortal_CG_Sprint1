package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.BookmarkedJobDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.service.IBookmarkJobService;
import com.jobportal.service.IFreelancerService;

@RestController
@RequestMapping(value="/jobportal/bookmarkedjob")
public class BookmarkedJobAPI 
{
	@Autowired
	private IBookmarkJobService iBookmarkJobService;
	
	@Autowired
	Environment environment;
	
	@GetMapping(value="/findbyid/{bookmarkJobID}")
	public ResponseEntity<BookmarkedJobDTO> findById(@PathVariable Integer bookmarkJobID, @RequestBody BookmarkedJobDTO bookmarkedJobDTO) throws Exception
	{
		BookmarkedJobDTO bookmarkedJob = iBookmarkJobService.findById(bookmarkJobID);
		return new ResponseEntity<>(bookmarkedJob, HttpStatus.OK);
	}
}

