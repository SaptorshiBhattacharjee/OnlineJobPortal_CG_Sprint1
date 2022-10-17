package com.jobportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.entity.BookmarkedJob;

public interface IBookmarkedJobDao extends CrudRepository<BookmarkedJob, Long>
{
}
