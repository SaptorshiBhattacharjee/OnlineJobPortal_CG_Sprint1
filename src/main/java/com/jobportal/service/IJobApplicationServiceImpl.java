
package com.jobportal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.FreelancerDTO;
import com.jobportal.dto.JobApplicationDTO;
import com.jobportal.dto.JobDTO;
//import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobApplication;
import com.jobportal.repository.IJobApplicationDao;

@Service
@Transactional
public class IJobApplicationServiceImpl implements IJobApplicationService{

	@Autowired
	IJobApplicationDao iJobApplicationDao;
	
	@Override
	public JobApplicationDTO applyToJob(JobDTO jobDTO, String coverletter, FreelancerDTO freelancerDTO) throws Exception{
		Job job = new Job();
		job.setId(jobDTO.getId());
		/*
		job.setSkill(jobDTO.getSKill());
		job.setRecruiter(jobDTO.getRecruiter());
		job.setPostedDate(jobDTO.getPostedDate());
		job.setAwardedTo(jobDTO.getAwarderTo());
		job.setJobApplicationsList(jobDTO.getApplicationsList());
		job.setActive(jobDTO.getActive());
		*/
		List<JobApplication> applications = freelancerDTO.getAppliedJobs();
		int idAppliedJob =0;
		int count = 0;
		for(JobApplication jobApp : applications) {
			
			if(jobApp.getJob().equals(job)) {
				count++;
				idAppliedJob = jobApp.getId();
				break;
			}
		}
		if(count > 0) {
			throw new Exception("Service.ALREADY_APPLIED");
		}
		
		JobApplication jobApplication = new JobApplication();
		jobApplication.setCoverLetter(coverletter);
		jobApplication.setJob(job);
		jobApplication.setAppliedDate(LocalDateTime.now());
		iJobApplicationDao.save(jobApplication);
		
		JobApplicationDTO jobApplicationDTO = new JobApplicationDTO();
		jobApplicationDTO.setId(jobApplication.getId());
		jobApplicationDTO.setCoverLetter(coverletter);
		jobApplicationDTO.setJob(job);
		jobApplicationDTO.setAppliedDate(jobApplication.getAppliedDate());
		
		return jobApplicationDTO;
		
		
		
		
	}

	@Override
	public JobApplicationDTO updateJobApplication(JobDTO jobDTO, String coverLetter, FreelancerDTO freelancerDTO) throws Exception{
		Job job = new Job();
		job.setId(jobDTO.getId());
		/*
		job.setSkill(jobDTO.getSKill());
		job.setRecruiter(jobDTO.getRecruiter());
		job.setPostedDate(jobDTO.getPostedDate());
		job.setAwardedTo(jobDTO.getAwarderTo());
		job.setJobApplicationsList(jobDTO.getApplicationsList());
		job.setActive(jobDTO.getActive());
		*/
		List<JobApplication> applications = freelancerDTO.getAppliedJobs();
		int idAppliedJob = 0;;
		int count = 0;
		for(JobApplication jobApp : applications) {
			
			if(jobApp.getJob().equals(job)) {
				count++;
				idAppliedJob = jobApp.getId();
				break;
			}
		}
		if(count == 0) {
			throw new Exception("Service.NOT_APPLIED");
		}
		
		Optional<JobApplication> optional = iJobApplicationDao.findById(idAppliedJob);
		JobApplication jobApplication = optional.orElseThrow(() -> new Exception());
		jobApplication.setCoverLetter(coverLetter);
		
		JobApplicationDTO jobApplicationDTO = new JobApplicationDTO();
		jobApplicationDTO.setId(jobApplication.getId());
		jobApplicationDTO.setCoverLetter(jobApplication.getCoverLetter());
		jobApplicationDTO.setJob(job);
		jobApplicationDTO.setAppliedDate(jobApplication.getAppliedDate());
		return jobApplicationDTO;
	}

	@Override
	public void remove(JobDTO jobDTO, FreelancerDTO freelancerDTO) throws Exception{
		Job job = new Job();
		job.setId(jobDTO.getId());
		/*
		job.setSkill(jobDTO.getSKill());
		job.setRecruiter(jobDTO.getRecruiter());
		job.setPostedDate(jobDTO.getPostedDate());
		job.setAwardedTo(jobDTO.getAwarderTo());
		job.setJobApplicationsList(jobDTO.getApplicationsList());
		job.setActive(jobDTO.getActive());
		*/
		List<JobApplication> applications = freelancerDTO.getAppliedJobs();
		int idAppliedJob = 0;
		int count = 0;
		for(JobApplication jobApp : applications) {
			
			if(jobApp.getJob().equals(job)) {
				count++;
				idAppliedJob = jobApp.getId();
				break;
			}
		}
		if(count == 0) {
			throw new Exception("Service.NOT_APPLIED");
		}
		Optional<JobApplication> optional = iJobApplicationDao.findById(idAppliedJob);
		JobApplication jobApplication = optional.orElseThrow(() -> new Exception());
		iJobApplicationDao.delete(jobApplication);
	}
	
	

	@Override
	public JobApplicationDTO findById(int id) throws Exception {
		Optional<JobApplication> optional = iJobApplicationDao.findById(id);
		JobApplication jobApplication = optional.orElseThrow(() -> new Exception("Service.NO_SUCH_JOB_APPLICATION"));
		
		JobApplicationDTO jobApplicationDTO = new JobApplicationDTO();
		jobApplicationDTO.setId(jobApplication.getId());
		jobApplicationDTO.setCoverLetter(jobApplication.getCoverLetter());
		jobApplicationDTO.setJob(jobApplication.getJob());
		jobApplicationDTO.setAppliedDate(jobApplication.getAppliedDate());
		return jobApplicationDTO;
		
	}

	



}


