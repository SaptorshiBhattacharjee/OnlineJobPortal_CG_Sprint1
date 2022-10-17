
package com.jobportal.dto;

import java.time.LocalDate;
import java.util.List;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.entity.JobApplication;

public class JobDTO {
	private int id;
	private Skill skill;
	private  RecruiterDTO postedBy;
	private  LocalDate postedDate;
	private FreelancerDTO awardedTo;
	private  List<JobApplication> jobApplications;
	private Boolean active;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill; // which we need to use skilldto or skill
	}
	public RecruiterDTO getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(RecruiterDTO postedBy) {
		this.postedBy = postedBy;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public FreelancerDTO getAwardedTo() {
		return awardedTo;
	}
	public void setAwardedTo(FreelancerDTO awardedTo) {
		this.awardedTo = awardedTo;
	}
	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}
	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return "JobDTO [id=" + id + ", skill=" + skill + ", postedBy=" + postedBy + ", postedDate=" + postedDate
=======
		return "job [id=" + id + ", skill=" + skill + ", postedBy=" + postedBy + ", postedDate=" + postedDate
>>>>>>> branch 'main' of https://github.com/SaptorshiBhattacharjee/OnlineJobPortal_CG_Sprint1.git
				+ ", awardedTo=" + awardedTo + ", jobApplications=" + jobApplications + ", active=" + active + "]";
	}
	
//	public Job toJob() {
//		Job j = new Job();
//		
//		return j;
//		
//	}
	public static boolean existsById(int id2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
