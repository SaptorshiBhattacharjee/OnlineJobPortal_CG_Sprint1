
package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.Job;

public interface IJobDao extends CrudRepository<Job, Integer>{
 
  
}
