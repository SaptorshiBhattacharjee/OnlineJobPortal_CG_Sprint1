
package com.jobportal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jobportal.dto.AdminDTO;
import com.jobportal.exception.InvalidAdminException;
import com.jobportal.service.IAdminService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value="/jobportal/admin")
public class AdminAPI {
	
	@Autowired
	private IAdminService iAdminService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/save")
	public ResponseEntity<String> save(@Valid @RequestBody AdminDTO adminDTO) throws Exception{
		//AdminDTO adminDTO = new AdminDTO(firstName, lastName, userName, password);
		String inserted = iAdminService.save(adminDTO);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value="/update")
	public ResponseEntity<String> update(@RequestBody AdminDTO adminDTO) throws Exception{
		String status = iAdminService.update(adminDTO);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		if(status.equals("SUCCESS"))
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		else 
			throw new InvalidAdminException("API.UPDATE_FAILED");
	}
	
	@GetMapping(value="/findbyid/{adminId}")
	public ResponseEntity<AdminDTO> findById(@PathVariable Integer adminId) throws Exception{
		
		AdminDTO admin = iAdminService.findById(adminId);
		return new ResponseEntity<>(admin, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/deletefreelancerbyid/{freelancerId}")
	public ResponseEntity<String> deleteFreelancerById(@PathVariable int freelancerId) throws Exception{
		
		String status = iAdminService.deleteFreelancerById(freelancerId);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleterecruiterbyid/{recruiterId}")
	public ResponseEntity<String> deleteRecruiterById(@PathVariable int recruiterId) throws Exception{
		
		String status = iAdminService.deleteRecruiterById(recruiterId);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
}
