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
		Skill skill = skillDTO.toSkill();
		Recruiter recruit = recruiterDTO.toRecruiter();
		JobDTO jobdto = new JobDTO();
        jobdto.setId(skill.getId());
        jobdto.setSkill(skill);
        jobdto.setPostedBy(recruit);
		jobdto.setPostedDate(LocalDate.now());
        jobdto.setAwardedTo(null);
        jobdto.setActive(true);
        jobdto.setJobApplications(null);
        Job j = jobdto.toJob();
        Job job2= iJobDao.save(j);
       
        return jobdto;
    }

	@Override
	public JobDTO findById(int id) throws InvalidJobException {
		Optional<Job> optional = iJobDao.findById(id);
		Job job = optional.orElseThrow(() -> new InvalidJobException("Service.NO_JOB_FOUND"));
		
		JobDTO jobDto = new JobDTO();
		jobDto.setId(job.getId());
		jobDto.setSkill(job.getSkill()); 
		jobDto.setActive(job.getActive());
		jobDto.setAwardedTo(jobDto.getAwardedTo());
		jobDto.setPostedDate(job.getPostedDate());
//		jobDto.setJobApplications(job.getJobApplications());
		jobDto.setPostedBy(jobDto.getPostedBy());
		
		return jobDto;
		
	}

	@Override
	public List<JobDTO> findJobsBySkill(SkillDTO skillDTO) throws InvalidJobException {
		List<JobDTO> JobDTOBySkill = new ArrayList<>();
		if(skillDTO==null) {
			throw new InvalidJobException("Service.ENTER_VALID_SKILL");
		}
		else {
	    Skill skill = skillDTO.toSkill();
        
		List<Job> joblist =(List<Job>) iJobDao.findAll();
		for(Job job : joblist) {
			Skill skill1 =job.getSkill();
			 if( skill1.getDescription().equals( skill.getDescription())&&
				 skill1.getName().equals(skill.getName())) {
			     JobDTOBySkill.add(job.toJobDTO());
		     }
		}
	}	
		return JobDTOBySkill;
		
	}
//	@Override
//	public void close(Long id) {
//		if (jobdao.existsById(id)) {
//			Job job = jobdao.findById(id).get();
//			job.setActive(false);
//			jobdao.save(job);
//		} else {
//			throw new InvalidJobException();
//		}
//	}

	@Override
	public void close(int id) throws InvalidJobException {

		if (iJobDao.existsById(id)) {
			Job job = iJobDao.findById(id).get();
			job.setActive(false);
			iJobDao.save(job);
		} else {
			throw new InvalidJobException("Service.NO_SUCH_JOB");
		}
		
	}

}
