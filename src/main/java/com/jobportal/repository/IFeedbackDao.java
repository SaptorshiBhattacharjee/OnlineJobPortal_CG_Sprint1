package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.Feedback;

public interface IFeedbackDao extends CrudRepository<Feedback, Integer>{

}
