
package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.JobApplication;

public interface IJobApplicationDao extends CrudRepository<JobApplication, Integer>{

}

