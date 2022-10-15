package com.jobportal.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class JobApplication {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
 	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="job_id")
	private Job job;
	private LocalDateTime appliedDate;
	private String coverLetter;
	
	public JobApplication() {
		super();
	}
	
	public JobApplication(int id, Job job, LocalDateTime appliedDate, String coverLetter) {
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
	public int hashCode() {
		return Objects.hash(id, appliedDate, coverLetter, job);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobApplication other = (JobApplication) obj;
		return Objects.equals(id, other.id) && Objects.equals(appliedDate, other.appliedDate)
				&& Objects.equals(coverLetter, other.coverLetter) && Objects.equals(job, other.job);
	}
	@Override
	public String toString() {
		return "JobApplication [Id=" + id + ", job=" + job + ", appliedDate=" + appliedDate + ", coverLetter="
				+ coverLetter + "]";
	}
	
	
	
}
