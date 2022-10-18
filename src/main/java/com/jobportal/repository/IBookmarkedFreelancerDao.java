package com.jobportal.repository;

import java.util.List;


import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.jobportal.entity.BookmarkedFreelancer;

public interface IBookmarkedFreelancerDao extends CrudRepository<BookmarkedFreelancer, Integer>{

	@Query("SELECT bf FROM BookmarkedFreelancer bf WHERE bf.skill_id = :skill_id AND bf.bookmarkedBy = :recruiter_Id")
	List<BookmarkedFreelancer> findBookmarkedFreelancerBySkill(@Param("skill_id") int skillId, @Param("recruiter_Id") int recruiterId );
	
	@Query("DELETE FROM BookmarkedFreelancer bf WHERE bf.freelancer_id = :freelancer_id AND bf.recruiter_id = :recruiter_id AND bf.skill_id = :skill_id")
	@Modifying
	@Transactional
	Integer removeBookmarkedFreelancer(@Param("freelancer_id") int freelancerId,@Param("skill_id") int skillId, @Param("recruiter_id") int recruiterId);
	
	
}


