package com.jobportal.service;

import com.jobportal.dto.RecruiterDTO;
import com.jobportal.entity.Recruiter;
import com.jobportal.exception.JobPortalException;

public interface IRecruiterService {
	
	public RecruiterDTO save(RecruiterDTO recruiterDTO) throws JobPortalException;
	public RecruiterDTO update(RecruiterDTO recruiterDTO) throws JobPortalException;
	public RecruiterDTO findById(Integer id) throws JobPortalException;

}
