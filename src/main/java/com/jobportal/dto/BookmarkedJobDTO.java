package com.jobportal.dto;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.jobportal.entity.BookmarkedJob;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.Skill;
import com.jobportal.entity.SkillExperience;
import com.jobportal.repository.IFreelancerDao;
import com.jobportal.repository.IJobDao;
import com.jobportal.repository.ISkillDao;
import com.jobportal.repository.ISkillExperienceDao;

public class BookmarkedJobDTO 
{
	@Autowired
	ISkillDao iSkillDao;
	
	@Autowired
	IJobDao iJobDao;
	
	@Autowired
	IFreelancerDao iFreelancerDao;
	
	private Integer bookmarkedJobDtoId;
//	private Skill skill;
//	private Job job;
//	private Freelancer freelancer;
	@NotNull(message="{bookmarkedJob.skill.absent}")
	private Integer skillId;
	@NotNull(message="{bookmarkedJob.job.absent}")
	private Integer jobId;
	@NotNull(message="{bookmarkedJob.freelancer.absent}")
	private Integer freelancerId;
	
	// defining the getter and setter methods
	public Integer getId() {
		return bookmarkedJobDtoId;
	}
	public void setId(Integer bookmarkedJobDtoId) {
		this.bookmarkedJobDtoId = bookmarkedJobDtoId;
	}
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public Integer getFreelancerId() {
		return freelancerId;
	}
	public void setFreelancerId(Integer freelancerId) {
		this.freelancerId = freelancerId;
	}
	
	//defining toString method
	/*@Override
	public String toString() {
		return "BookmarkedJobDTO [bookmarkedJobDtoId=" + bookmarkedJobDtoId + ", skill=" + skill + ", job=" + job + ", freelancer=" + freelancer + "]";
	}*/
	
	public BookmarkedJob toBookmarkedJobEntity()
	{
		BookmarkedJob bookmarkedJob = new BookmarkedJob();
		
		bookmarkedJob.setId(this.getId());
//		Optional<Job> optional = iJobDao.findById(this.jobId);
//		Job job = optional.orElse(null);
//		jobApplication.setJob(job);
		Optional<Skill> optionalSkill = iSkillDao.findById(this.skillId);
		Skill skill = optionalSkill.orElse(null);
		bookmarkedJob.setSkill(skill);
		
		Optional<Job> optionalJob = iJobDao.findById(this.jobId);
		Job job = optionalJob.orElse(null);
		bookmarkedJob.setJob(job);
		
		Optional<Freelancer> optionalFreelancer = iFreelancerDao.findById(this.freelancerId);
		Freelancer freelancer = optionalFreelancer.orElse(null);
		bookmarkedJob.setFreelancer(freelancer);
		
		return(bookmarkedJob);
	}
}
