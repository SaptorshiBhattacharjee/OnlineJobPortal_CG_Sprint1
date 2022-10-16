package com.jobportal.service;

import com.jobportal.dto.RecruiterDTO;

public interface IRecruiterService {
	
	public RecruiterDTO save(RecruiterDTO recruiterDTO) throws Exception;
	public RecruiterDTO update(RecruiterDTO recruiterDTO) throws Exception;
	public RecruiterDTO findById(Integer id) throws Exception;

}
