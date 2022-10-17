package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.Freelancer;

public interface IFreelancerDao extends CrudRepository<Freelancer, Long>
{

}
