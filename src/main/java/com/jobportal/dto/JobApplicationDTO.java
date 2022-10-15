package com.jobportal.dto;

import java.time.LocalDateTime;


import com.jobportal.entity.Job;

public class JobApplicationDTO {

	
	private int id;
	private Job job;
	private LocalDateTime appliedDate;
	private String coverLetter;
	
	public JobApplicationDTO() {
		super();
	}
	
	public JobApplicationDTO(int id, Job job, LocalDateTime appliedDate, String coverLetter) {
		super();
		this.id = id;
		this.job = job;
		this.appliedDate = appliedDate;
		this.coverLetter = coverLetter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(LocalDateTime appliedDate) {
		this.appliedDate = appliedDate;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	@Override
	public String toString() {
		return "JobApplicationDTO [id=" + id + ", job=" + job + ", appliedDate=" + appliedDate + ", coverLetter="
				+ coverLetter + "]";
	}
	
	

}
