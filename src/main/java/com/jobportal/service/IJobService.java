package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.JobDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.exception.InvalidJobException;

public interface IJobService {
	public JobDTO postjob(SkillDTO skillDTO,RecruiterDTO recruiterDTO)throws InvalidJobException;
	public JobDTO findById(int id) throws InvalidJobException;
	public List<JobDTO> findJobsBySkill(SkillDTO skillDTO)throws InvalidJobException;
    public void close(int id)throws InvalidJobException;
}
