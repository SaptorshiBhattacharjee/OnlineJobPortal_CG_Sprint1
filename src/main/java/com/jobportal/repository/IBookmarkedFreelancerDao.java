package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.BookmarkedFreelancer;

public interface IBookmarkedFreelancerDao extends CrudRepository<BookmarkedFreelancer, Integer>{

}
