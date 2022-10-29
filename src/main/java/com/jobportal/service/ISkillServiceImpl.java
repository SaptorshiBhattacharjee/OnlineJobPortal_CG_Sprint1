package com.jobportal.service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.Skill;
import com.jobportal.exception.InvalidSkillException;
import com.jobportal.repository.ISkillDao;

@Service(value="iSkillService")
@Transactional
public class ISkillServiceImpl implements ISkillService{
	
	@Autowired
	ISkillDao iSkillDao;
	SkillDTO skillDTO;
	
	@Override
	public SkillDTO save(SkillDTO skillDTO) throws InvalidSkillException {
		Skill skill = new Skill();	
		skill.setId(skillDTO.getId());
		skill.setName(skillDTO.getName());
		skill.setDescription(skillDTO.getDescription());		
		iSkillDao.save(skill);
		return skillDTO;
	}
	
	@Override
	public SkillDTO update(SkillDTO skillDTO) throws InvalidSkillException{	
		Optional<Skill> optional = iSkillDao.findById(skillDTO.getId());
		Skill skill1 = optional.orElseThrow(() -> new InvalidSkillException("CANNOT BE UPDATED:INVALID SKILLID"));	
		skill1.setId(skillDTO.getId());
		skill1.setName(skillDTO.getName());
		skill1.setDescription(skillDTO.getDescription());	
		iSkillDao.save(skill1);
		return skillDTO;
	}
		
	@Override
	public void remove(SkillDTO skillDTO) throws InvalidSkillException{
		Skill skill = new Skill();
		skill.setId(skill.getId());
		Optional<Skill> optional = iSkillDao.findById(skillDTO.getId());
		Skill skill1 = optional.orElseThrow(() -> new InvalidSkillException("INVALID SKILLID"));
		iSkillDao.delete(skill1);
		
	}
	
}
