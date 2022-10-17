package com.jobportal.service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.Skill;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.ISkillDao;

@Service(value="iSkillService")
@Transactional
public class ISkillServiceImpl implements ISkillService{
	
	@Autowired
	ISkillDao iSkillDao;
	SkillDTO skillDTO;
	
	@Override
	public SkillDTO save(SkillDTO skillDTO) throws Exception {
		Skill skill = new Skill();		
		skillDTO.setName(skillDTO.getName());
		skillDTO.setDescription(skillDTO.getDescription());		
		iSkillDao.save(skill);
		return skillDTO;
	}
	
	@Override
	public SkillDTO update(SkillDTO skillDTO) throws Exception{	
		Optional<Skill> optional = iSkillDao.findById(skillDTO.getId());
		Skill skill1 = optional.orElseThrow(() -> new JobPortalException("Service.ADMIN_NOT_FOUND"));	
		skill1.setName(skillDTO.getName());
		skill1.setDescription(skillDTO.getDescription());		
		return skillDTO;
	}
		
	@Override
	public void remove(SkillDTO skillDTO) throws Exception{
		Skill skill = new Skill();
		skill.setId(skill.getId());
		Optional<Skill> optional = iSkillDao.findById(skillDTO.getId());
		Skill skill1 = optional.orElseThrow(() -> new Exception("Service.ADMIN_NOT_FOUND"));
		iSkillDao.delete(skill1);
		
		
//		if (iSkillDao.existsById(skillDTO.getId()))
//		{
//		iSkillDao.deleteById(skillDTO.getId());
//		}else {
//			throw new Exception("InvalidskillId");
//		}		
		
	}
	
}
