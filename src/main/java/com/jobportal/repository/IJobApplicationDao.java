
package com.jobportal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.JobApplication;

public interface IJobApplicationDao extends CrudRepository<JobApplication, Integer>{
	Optional<JobApplication> findByJobIdAndFreelancerId (int jobId, int  freelancerId);
}

