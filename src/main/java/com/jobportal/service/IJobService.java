package com.jobportal.service;
//import
import java.util.List;

import com.jobportal.dto.JobDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.exception.JobPortalException;


public interface IJobService {
	public JobDTO postjob(SkillDTO skillDTO,RecruiterDTO recruiterDTO)throws JobPortalException;
	public JobDTO findById(int id) throws JobPortalException;
	public List<JobDTO> findJobsBySkill(SkillDTO skillDTO)throws JobPortalException;
    public void close(JobDTO jobDTO)throws JobPortalException;
}
