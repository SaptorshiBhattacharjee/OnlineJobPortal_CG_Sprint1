package com.jobportal.service;

import com.jobportal.dto.SkillDTO;


public interface ISkillService {
	
	public SkillDTO save(SkillDTO skillDTO) throws Exception;
	public SkillDTO update(SkillDTO skillDTO) throws Exception;
	public void remove(SkillDTO skillDTO) throws Exception;

}
