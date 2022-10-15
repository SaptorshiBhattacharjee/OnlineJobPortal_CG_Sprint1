
package com.jobportal.dto;

import java.time.LocalDate;
import java.util.List;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.Skill;
import com.jobportal.entity.JobApplication;

public class JobDTO {
	private long id ;
	private Skill skill;
	private  Recruiter postedBy;
	private  LocalDate postedDate;
	private Freelancer awardedTo;
	private  List<JobApplication> jobApplications;
	private Boolean active;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Recruiter getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(Recruiter postedBy) {
		this.postedBy = postedBy;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public Freelancer getAwardedTo() {
		return awardedTo;
	}
	public void setAwardedTo(Freelancer awardedTo) {
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
		return "job [id=" + id + ", skill=" + skill + ", postedBy=" + postedBy + ", postedDate=" + postedDate
				+ ", awardedTo=" + awardedTo + ", jobApplications=" + jobApplications + ", active=" + active + "]";
	}
	
}
