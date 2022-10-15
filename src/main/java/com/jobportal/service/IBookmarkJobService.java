package com.jobportal.service;

import java.util.List;

import com.jobportal.entity.BookmarkedJob;
import com.jobportal.entity.Freelancer;
import com.jobportal.entity.Job;
import com.jobportal.entity.Skill;
import com.jobportal.exception.OnlineJobPortalException;

public interface IBookmarkJobService 
{
	public BookmarkedJob bookmarkJob(Job job,Freelancer freelancer)throws OnlineJobPortalException;
	public void removeBookmark(Job job,Freelancer freelancer)throws OnlineJobPortalException;
	public List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill,Freelancer freelancer)throws OnlineJobPortalException;
	public BookmarkedJob findById(Long id)throws OnlineJobPortalException;
}
