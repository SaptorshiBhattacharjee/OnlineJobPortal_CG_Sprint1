package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.JobDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.IJobService;

@RestController
@RequestMapping("value=/jobportal/job")
public class JobAPI {
     @Autowired
	private IJobService ijobservice;
     
     @Autowired
 	Environment environment;
     
     @PostMapping(value ="/postjob")
     public ResponseEntity<String> postjob(SkillDTO skillDTO,RecruiterDTO recruiterDTO)throws JobPortalException{
    	 JobDTO posted = ijobservice.postjob(skillDTO, recruiterDTO);
    	 String successMessage = environment.getProperty("API.JOBPOSTED_SUCCESSFULLY");
    	 return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
     }
     
}
