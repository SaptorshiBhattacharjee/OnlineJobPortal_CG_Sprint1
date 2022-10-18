package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.jobportal.entity.SkillExperience;
import com.jobportal.repository.ISkillExperienceDao;
import com.jobportal.service.ISkillExperienceService;
import com.jobportal.service.ISkillExperienceServiceImpl;


@SpringBootTest
@ComponentScan("com.jobportal.service.ISkillService")
public class SkillExperienceServiceTests {
	
		@Mock
		private ISkillExperienceDao iSkillExperienceDao;

		@InjectMocks
		private ISkillExperienceService iSkillService = new ISkillExperienceServiceImpl();
		
		@BeforeEach
		void setup3(){
		SkillExperience skillExperience = new SkillExperience();
		skillExperience.setId(2);
		skillExperience.setYears(3);	
		MockitoAnnotations.initMocks(this);

		}
		
		@Test
		void addSkill() throws InvalidSkillExpeirnceException{
			
		}
	
	
}
