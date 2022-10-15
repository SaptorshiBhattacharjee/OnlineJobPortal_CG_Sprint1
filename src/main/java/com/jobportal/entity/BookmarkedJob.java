package com.jobportal.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BookmarkedJob 
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="skill_id")	//one book-mark job is mapped to one skill
	private Skill skill;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="job_id")	//one book-mark job is mapped to one job
	private Job job;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="freelancer_id")
	private Freelancer freelancer;
	
	// defining default and parameterized constructors 
	public BookmarkedJob() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookmarkedJob(Long id, Skill skill, Job job, Freelancer freelancer) {
		super();
		this.id = id;
		this.skill = skill;
		this.job = job;
		this.freelancer = freelancer;
	}
	
	// defining the getter and setter methods
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
	
	// defining hashcode and equals method
	@Override
	public int hashCode() {
		return Objects.hash(freelancer, id, job, skill);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookmarkedJob other = (BookmarkedJob) obj;
		return Objects.equals(freelancer, other.freelancer) && id == other.id && Objects.equals(job, other.job)
				&& Objects.equals(skill, other.skill);
	}
	
	//defining toString method
	@Override
	public String toString() {
		return "BookmarkedJob [id=" + id + ", skill=" + skill + ", job=" + job + ", freelancer=" + freelancer + "]";
	}
}
