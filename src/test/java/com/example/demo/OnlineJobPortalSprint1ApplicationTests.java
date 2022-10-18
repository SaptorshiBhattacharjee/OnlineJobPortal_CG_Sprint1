package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.dto.AdminDTO;
import com.jobportal.exception.InvalidAdminException;
import com.jobportal.repository.IAdminDao;
import com.jobportal.service.IAdminService;
import com.jobportal.service.IAdminServiceImpl;

@SpringBootTest
class OnlineJobPortalSprint1ApplicationTests {


	@Mock
	IAdminDao iAdminDao;
	
	@InjectMocks
	IAdminService iAdminService =  new IAdminServiceImpl();
	
	@Test
	public void addNewAdminTest() throws InvalidAdminException {
		AdminDTO adminDTO  = new AdminDTO();
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("John123");
		Mockito.when(iAdminDao.save(adminDTO.toAdmin())).thenReturn(adminDTO.toAdmin());
		AdminDTO actual = iAdminService.save(adminDTO);
		Assertions.assertEquals(adminDTO, actual);
	} 
/*	
	@Test
	public void authenticateCustomerTestInValidCredentials() throws InvalidAdminException {
		AdminDTO adminDTOFromRepository  = new AdminDTO();
		adminDTOFromRepository.setFirstName("John");
		adminDTOFromRepository.setLastName("Jack");
		adminDTOFromRepository.setPassword("John123");
		
		AdminDTO adminDTO  = new AdminDTO();
		adminDTO.setFirstName("");
		adminDTO.setLastName("");
		adminDTO.setPassword("");
	
		
		Mockito.when(iAdminDao.save(adminDTO.toAdmin())).thenReturn(adminDTOFromRepository.toAdmin());
	    InValidAdminException exception=Assertions.assertThrows(InvalidAdminException.class,()->InvalidAdminService.saver(adminDTO));
		Assertions.assertEquals("Service.WRONG_CREDENTIALS", exception.getMessage());
	}
*/	
	@Test
	public void updateAdminTests() throws InvalidAdminException {
		AdminDTO adminDTO  = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("John123");
		Optional<com.jobportal.entity.Admin> optional= Optional.of(adminDTO.toAdmin());
		Mockito.when(iAdminDao.findById(adminDTO.getId())).thenReturn(optional);
		AdminDTO actual = iAdminService.update(adminDTO);
		Assertions.assertEquals(adminDTO ,actual);
	}
	/*
	@Test
	public void invalidAdminUpdateTests() throws InvalidAdminException{
		AdminDTO adminDTO  = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("John123");
		Mockito.when(iAdminDao.findById(adminDTO.getId())).thenReturn(null);
		AdminDTO actual = iAdminService.update(adminDTO);
		Assertions.assertThrows(InvalidAdminException, actual);
		
	}
	*/

}
