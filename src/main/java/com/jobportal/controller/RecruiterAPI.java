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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.AdminDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.exception.InvalidRecruiterException;
import com.jobportal.service.IAdminService;
import com.jobportal.service.IRecruiterService;

@RestController
@RequestMapping(value="/jobportal/recruiter")
public class RecruiterAPI {
	
	@Autowired
	private IRecruiterService iRecruiterService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/save")
	public ResponseEntity<String> save(@RequestParam String firstName,@RequestParam String lastName) throws Exception{
		String updatesRecruiter = iRecruiterService.save(firstName,lastName);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS");
		if(updatesRecruiter.equals("SUCCESS")){
			return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		}
		else {
			throw new InvalidRecruiterException("API.INSERT_FAILED");
		}
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<String> update(@RequestBody RecruiterDTO recruiterDTO) throws Exception{
		RecruiterDTO addedRecruiter = iRecruiterService.update(recruiterDTO);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/findbyid/{id}")
	public ResponseEntity<RecruiterDTO> findById(@PathVariable Integer id) throws InvalidRecruiterException{
		RecruiterDTO recruiter = iRecruiterService.findById(id);
		return new ResponseEntity<>(recruiter, HttpStatus.OK);
	}
	

}
