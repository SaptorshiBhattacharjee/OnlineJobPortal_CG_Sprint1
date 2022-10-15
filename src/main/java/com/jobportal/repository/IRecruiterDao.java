package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.Recruiter;

public interface IRecruiterDao extends CrudRepository<Recruiter, Integer>{

}
