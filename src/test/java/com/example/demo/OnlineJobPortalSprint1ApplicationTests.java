package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.OnlineJobPortalSprint1Application;
import com.jobportal.dto.AdminDTO;
import com.jobportal.dto.SkillDTO;
import com.jobportal.entity.Admin;
import com.jobportal.entity.Skill;
import com.jobportal.entity.SkillExperience;
import com.jobportal.exception.InvalidAdminException;
import com.jobportal.exception.InvalidSkillException;
import com.jobportal.repository.ISkillDao;
import com.jobportal.service.ISkillExperienceService;
import com.jobportal.service.ISkillExperienceServiceImpl;
import com.jobportal.service.ISkillService;
import com.jobportal.service.ISkillServiceImpl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.when;




@SpringBootTest
class OnlineJobPortalSprint1ApplicationTests{
//	@Mock
//	private ISkillDao iSkillDao;
//	private Skill skill;
//
//
//	@InjectMocks
//	private ISkillService iSkillService = new ISkillServiceImpl();
//
//
//	@BeforeEach
//	void setup2() {
//		skill = new Skill();
//		skill.setId(1);
//		skill.setName("Priya");
//		skill.setDescription("WonderWomen");
////		skillExperience = new SkillExperience();
////		skillExperience.setId(2);
////		skillExperience.setYears(3);	
////		MockitoAnnotations.initMocks(this);
//	
//				
//		
//	}
//	
//	@Test
//	void saveSkill() throws InvalidSkillException{
//		SkillDTO skillDTO = new SkillDTO();
//		skillDTO.setId(1);
//		skillDTO.setName("Priya");
//		skillDTO.setDescription("WonderWomen");
//		Mockito.when(iSkillDao.save(skillDTO.toSkill())).thenReturn(skillDTO.toSkill());
//		SkillDTO actualSkillDTO = iSkillService.save(skillDTO);
//		Assertions.assertEquals(actualSkillDTO, skillDTO);
//	}
//	
//	@Test
//	void updateSkillTest() throws InvalidSkillException{
//		SkillDTO skillDTO = new SkillDTO();
//		skillDTO.setId(1);
//		skillDTO.setName("Priya");
//		skillDTO.setDescription("WonderWomen");	
//		SkillDTO returnedSkillDTO = new SkillDTO();
//		returnedSkillDTO.setId(1);
//		returnedSkillDTO.setName("Priya");
//		returnedSkillDTO.setDescription("BeautyBeast");		
//		Optional <Skill> optional = Optional.of(returnedSkillDTO.toSkill());
//		Mockito.when(iSkillDao.findById(skillDTO.getId())).thenReturn(optional);
//		SkillDTO actual = iSkillService.update(skillDTO);
//		Assertions.assertEquals(skillDTO, actual);		
//	}
//	
//	@Test
//	void updatefailedSkillTest() throws InvalidSkillException{
//		SkillDTO skillDTO = new SkillDTO();
//		skillDTO.setId(1);
//		skillDTO.setName("Priya");
//		skillDTO.setDescription("WonderWomen");	
//		Mockito.when(iSkillDao.findById(skillDTO.getId())).thenReturn(null);
//		SkillDTO actual = iSkillService.update(skillDTO);
//		InvalidSkillException exception = Assertions.assertThrows(InvalidSkillException.class,() -> iSkillService.update(skillDTO));
//		Assertions.assertEquals("Service.SKILL_NOT_FOUND", exception.getMessage());
//		
//	}
//	
//	@Test
//	void removeSKill() throws InvalidSkillException{
//		SkillDTO skillDTO = new SkillDTO();
//		skillDTO.setId(1);
//		skillDTO.setName("Priya");
//		skillDTO.setDescription("WonderWomen");	
//		
//		
//		
//	}
//	
	

	
}


		


