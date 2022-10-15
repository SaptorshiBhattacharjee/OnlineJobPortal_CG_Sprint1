package com.jobportal.service;

import com.jobportal.dto.RecruiterDTO;

public interface IRecruiterService {
	
	public RecruiterDTO save(RecruiterDTO recruiterDTO) throws Exception;
	public RecruiterDTO findBy(long id) throws Exception;
	public RecruiterDTO update(RecruiterDTO recruiterDTO) throws Exception;

}
