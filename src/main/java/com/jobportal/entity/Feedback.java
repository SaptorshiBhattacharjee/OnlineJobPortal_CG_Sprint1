package com.jobportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jobportal.dto.AdminDTO;
import com.jobportal.dto.FeedbackDTO;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Integer rating;
	private String comment;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruiter_id", unique = true)	
	private Recruiter createdBy;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancer_id", unique = true)
	private Freelancer createdFor;
	
	public Feedback(long id, Integer rating, String comment, Recruiter createdBy, Freelancer createdFor) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.createdBy = createdBy;
		this.createdFor = createdFor;
	}
	
	
	public Feedback() {
		super();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Recruiter getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Recruiter createdBy) {
		this.createdBy = createdBy;
	}
	public Freelancer getCreatedFor() {
		return createdFor;
	}
	public void setCreatedFor(Freelancer createdFor) {
		this.createdFor = createdFor;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", rating=" + rating + ", comment=" + comment + ", createdBy=" + createdBy
				+ ", createdFor=" + createdFor + "]";
	}
	
	public FeedbackDTO toFeedbackDTO() {
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		feedbackDTO.setId(this.id);
		feedbackDTO.setRating(this.rating);
		feedbackDTO.setComment(this.comment);
		feedbackDTO.setCreatedBy(this.createdBy);
		feedbackDTO.setCreatedFor(this.createdFor);
		return feedbackDTO;
	}

}
