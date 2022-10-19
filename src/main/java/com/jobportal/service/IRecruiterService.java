package com.jobportal.service;

import com.jobportal.dto.RecruiterDTO;
import com.jobportal.exception.InvalidRecruiterException;

public interface IRecruiterService {
	
	public RecruiterDTO save(RecruiterDTO recruiterDTO) throws InvalidRecruiterException;
	public RecruiterDTO update(RecruiterDTO recruiterDTO) throws InvalidRecruiterException;
	public RecruiterDTO findById(int id) throws InvalidRecruiterException;

}
