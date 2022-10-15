package com.jobportal.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.Skill;
import com.jobportal.repository.ISkillDao;

@Service(value="iSkillService")
@Transactional
public class ISkillServiceImpl implements ISkillService{
	
	@Autowired
	ISkillDao iSkillDao;
	SkillDTO skillDTO;
	
	@Override
	public SkillDTO save(SkillDTO skillDTO) throws Exception {
		skillDTO.setName(skillDTO.getName());
		skillDTO.setDescription(skillDTO.getDescription());	
		iSkillDao.save(skillDTO);
		return skillDTO;
	}
	
	@Override
	public SkillDTO update(SkillDTO skillDTO) throws Exception{
		Optional<Skill> optional = iSkillDao.findById(skillDTO.getId());
		Skill skill = optional.orElseThrow(() -> new Exception("Service.ADMIN_NOT_FOUND"));
		skill.setName(skillDTO.getName());
		skill.setDescription(skillDTO.getDescription());
		return skillDTO;
	}
	
	
	@Override
	public void remove(SkillDTO skillDTO) throws Exception{
		Optional<Skill> optional = iSkillDao.findById(skillDTO.getId());
		Skill skill = optional.orElseThrow(() -> new Exception("Service.ADMIN_NOT_FOUND"));
		iSkillDao.delete(skill);
	}

}
