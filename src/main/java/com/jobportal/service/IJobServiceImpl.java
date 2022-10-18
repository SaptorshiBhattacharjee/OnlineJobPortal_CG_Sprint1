package com.jobportal.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.dto.JobDTO;
import com.jobportal.dto.RecruiterDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobApplication;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.exception.InvalidJobException;
import com.jobportal.repository.IJobDao;

@Service(value="iJobsService")
@Transactional
public class IJobServiceImpl implements IJobService{
	
    @Autowired
    IJobDao iJobDao;
    
	@Override
	public JobDTO postjob(SkillDTO skillDTO, RecruiterDTO recruiterDTO) throws InvalidJobException {
		Skill skill = new Skill();
		skill.setId(skillDTO.getId());
		Recruiter recruit = new Recruiter();
		recruit.setId(recruiterDTO.getId());
		JobDTO jobdto = new JobDTO();
        JobApplication jobApplications = jobdto.getJobApplications();
        Freelancer freelancer = new Freelancer();
        Recruiter recruiter = new Recruiter();
        jobdto.setId(jobdto.getId());
        jobdto.setSkill(skill);
        jobdto.setPostedBy(recruiter);
		jobdto.setPostedDate(LocalDate.now());
        jobdto.setAwardedTo(freelancer);
        jobdto.setActive(true);
        jobdto.setJobApplications(jobApplications);
        Job j = jobdto.toJob();
        Job job2= iJobDao.save(j);
       
        return jobdto;
    }

	@Override
	public JobDTO findById(int id) throws InvalidJobException {
		Optional<Job> optional = iJobDao.findById(id);
		Job job = optional.orElseThrow(() -> new InvalidJobException("Service.NO_SUCH_JOB"));
		
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
	public List<JobDTO> findJobsBySkill(SkillDTO skillDTO) throws InvalidJobException {
		Skill skill = new Skill();
		skill.setId(skillDTO.getId());
		skill.setName(skillDTO.getName());
		skill.setDescription(skillDTO.getDescription());
		
		List<Job> JobBySkill = iJobDao.findJobBySkill(skill);
		List<JobDTO> JobDTOBySkill = new ArrayList<>();
		
		for(Job job : JobBySkill) { // list job nunchi oka okati list of job dto  
			JobDTO jobDTO = new JobDTO();
			jobDTO.setId(job.getId());
			jobDTO.setAwardedTo(job.getAwardedTo());
			jobDTO.setJobApplications(job.getJobApplications());
			jobDTO.setPostedBy(job.getPostedBy()); 
			jobDTO.setPostedDate(job.getPostedDate());
			jobDTO.setActive(job.getActive());
			jobDTO.setSkill(job.getSkill());
			JobDTOBySkill.add(jobDTO);
		}
		return JobDTOBySkill;
	
	}

	@Override
	public void close(JobDTO jobDTO) throws InvalidJobException {
		
		int id =jobDTO.getId();
		if (iJobDao.existsById(id)) {
			Job job = iJobDao.findById(id).get();
			job.setActive(false);
			//iJobDao.save(job);
		} else {
			throw new InvalidJobException("Service.NO_SUCH_JOB");
		}
		
	}

}
