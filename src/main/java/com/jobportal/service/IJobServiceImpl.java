package com.jobportal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.jobportal.dto.BookmarkedFreelancerDTO;
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.BookmarkedFreelancer;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobApplication;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.IJobDao;
import com.jobportal.repository.ISkillDao;

public class IJobServiceImpl implements IJobService{
	
    @Autowired
    IJobDao iJobDao;
    
	@Override
	public JobDTO postjob(SkillDTO skillDTO, RecruiterDTO recruiterDTO) throws JobPortalException {
		Skill skill = new Skill();
		skill.setId(skillDTO.getId());
		Recruiter recruit = new Recruiter();
		recruit.setId(recruiterDTO.getId());
		Job job = new Job();
		JobDTO jobdto = new JobDTO();
        List<JobApplication> jobApplications = jobdto.getJobApplications();
        FreelancerDTO freelancerdto = new FreelancerDTO ();

        jobdto.setId(jobdto.getId());
        jobdto.setSkill(skill);

        jobdto.setId(job.getId());

        jobdto.setSkill(skill);

        jobdto.setSkill(skill);

		jobdto.setPostedBy(recruiterDTO);
		jobdto.setPostedDate(LocalDate.now());
        jobdto.setAwardedTo(freelancerdto);
        jobdto.setActive(true);
        jobdto.setJobApplications(jobApplications);
        return jobdto;
        

	
	
		
	
	
	}

	@Override
	public JobDTO findById(int id) throws JobPortalException  {
		Optional<Job> optional = iJobDao.findById(id);
		Job job = optional.orElseThrow(() -> new JobPortalException("Service.NO_SUCH_JOB"));
		
		JobDTO jobDto = new JobDTO();
		jobDto.setId(job.getId());
		jobDto.setSkill(job.getSkill()); 
		jobDto.setActive(job.getActive());
		jobDto.setAwardedTo(jobDto.getAwardedTo());
		jobDto.setPostedDate(job.getPostedDate());
		jobDto.setJobApplications(job.getJobApplications());
		jobDto.setPostedBy(jobDto.getPostedBy());
		return jobDto;
		
	}

	@Override
	public List<JobDTO> findJobsBySkill(SkillDTO skillDTO) throws JobPortalException {
		Skill skill = new Skill();
		Recruiter recruiter = new Recruiter();
        skill.setId(skillDTO.getId());
		skill.setName(skillDTO.getName());
		skill.setDescription(skillDTO.getDescription());
		List<Job> JobBySkill = iJobDao.findJobBySkill(skill);
		List<JobDTO> JobDTOBySkill = new ArrayList<>();
		
		for(Job job : JobBySkill) {
			JobDTO jobDTO = new JobDTO();
			jobDTO.setId(job.getId());
			//jobDTO.setAwardedTo(job.getAwardedTo());
			jobDTO.setJobApplications(job.getJobApplications());
			//jobDTO.setPostedBy(job.getPostedBy()); which we need to use dto or normal
			jobDTO.setPostedDate(job.getPostedDate());
			jobDTO.setActive(job.getActive());
			jobDTO.setSkill(job.getSkill());
			
			JobDTOBySkill.add(jobDTO);
		}
		return JobDTOBySkill;
	
	}

	@Override
	public void close(JobDTO jobDTO) throws JobPortalException {
		
		int id =jobDTO.getId();
		if (iJobDao.existsById(id)) {
			Job job = iJobDao.findById(id).get();
			job.setActive(false);
			//iJobDao.save(job);
		} else {
			throw new JobPortalException("Service.NO_SUCH_JOB");
		}
		
	}

}
