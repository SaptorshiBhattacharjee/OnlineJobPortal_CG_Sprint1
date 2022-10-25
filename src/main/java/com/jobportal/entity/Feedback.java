package com.jobportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jobportal.dto.AdminDTO;
import com.jobportal.dto.FeedbackDTO;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;
	private Integer rating;
	private String comment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recruiter_id", unique = true)
	@JsonBackReference
	private Recruiter createdBy;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancer_id", unique = true)
	@JsonBackReference
	private Freelancer createdFor;
	
	public Feedback(int feedbackId, Integer rating, String comment, Recruiter createdBy, Freelancer createdFor) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.comment = comment;
		this.createdBy = createdBy;
		this.createdFor = createdFor;
	}
	
	
	public Feedback() {
		super();
	}


	public int getId() {
		return feedbackId;
	}
	public void setId(int id) {
		this.feedbackId = id;
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
		return "Feedback [id=" + feedbackId + ", rating=" + rating + ", comment=" + comment + ", createdBy=" + createdBy
				+ ", createdFor=" + createdFor + "]";
	}
	
	public FeedbackDTO toFeedbackDTO() {
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		feedbackDTO.setId(this.feedbackId);
		feedbackDTO.setRating(this.rating);
		feedbackDTO.setComment(this.comment);
		feedbackDTO.setCreatedBy(this.createdBy);
		feedbackDTO.setCreatedFor(this.createdFor);
		return feedbackDTO;
	}

}
