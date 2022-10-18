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

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.service.IFreelancerService;

@RestController
@RequestMapping("value=/jobportal/freelancer")
public class FreelancerAPI 
{
	@Autowired
	private IFreelancerService ifreelancerService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/save")
	public ResponseEntity<String> update(@RequestBody FreelancerDTO freelancerDTO) throws Exception
	{
		FreelancerDTO updatesFreelancer = ifreelancerService.save(freelancerDTO);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<String> save(@RequestBody FreelancerDTO freelancerDTO) throws Exception
	{
		FreelancerDTO addedFreelancer = ifreelancerService.update(freelancerDTO);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/findbyid/{freelancerId}")
	public ResponseEntity<FreelancerDTO> findById(@PathVariable Integer freelancerId, @RequestBody FreelancerDTO freelancerDTO) throws Exception
	{
		FreelancerDTO freelancer = ifreelancerService.findById(freelancerId);
		return new ResponseEntity<>(freelancer, HttpStatus.OK);
	}
}
