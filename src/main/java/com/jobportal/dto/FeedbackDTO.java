package com.jobportal.dto;

import com.jobportal.entity.Feedback;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Recruiter;

public class FeedbackDTO {
	private int id;
	private Integer rating;
	private String comment;
	private Recruiter createdBy;
	private Freelancer createdFor;
	
	
	
	public FeedbackDTO() {
		super();
	}
	
	
	public FeedbackDTO(int id, Integer rating, String comment, Recruiter createdBy, Freelancer createdFor) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.createdBy = createdBy;
		this.createdFor = createdFor;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		return "FeedbackDTO [id=" + id + ", rating=" + rating + ", comment=" + comment + ", createdBy=" + createdBy
				+ ", createdFor=" + createdFor + "]";
	}
	public Feedback toFeedback() {
		Feedback feedback = new Feedback();
		feedback.setId(this.id);
		feedback.setRating(this.rating);
		feedback.setComment(this.comment);
		feedback.setCreatedBy(this.createdBy);
		feedback.setCreatedFor(this.createdFor);
		return feedback;
	}

}
