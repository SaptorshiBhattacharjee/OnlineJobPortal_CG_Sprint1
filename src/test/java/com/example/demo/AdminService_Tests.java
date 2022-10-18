package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobportal.OnlineJobPortalSprint1Application;
import com.jobportal.dto.AdminDTO;
import com.jobportal.entity.Admin;
import com.jobportal.exception.InvalidAdminException;
import com.jobportal.repository.IAdminDao;
import com.jobportal.service.IAdminService;
import com.jobportal.service.IAdminServiceImpl;

@SpringBootTest(classes=OnlineJobPortalSprint1Application.class)
class AdminService_Tests {

	@InjectMocks
	private IAdminService iAdminService = new IAdminServiceImpl();
	
	@Mock
	private IAdminDao iAdminDao;
	
	
	@Test
	void adminAddTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		Mockito.when(iAdminDao.save(adminDTO.toAdmin())).thenReturn(adminDTO.toAdmin());
		AdminDTO actual = iAdminService.save(adminDTO);
		Assertions.assertEquals(actual, adminDTO);
		
	}
	@Test
	void adminUpdateTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		
		AdminDTO returnedAdminDTO = new AdminDTO() ;
		returnedAdminDTO.setId(1);
		returnedAdminDTO.setFirstName("John");
		returnedAdminDTO.setLastName("Jack");
		returnedAdminDTO.setPassword("2345");
		Optional <Admin> optional = Optional.of(returnedAdminDTO.toAdmin());
		Mockito.when(iAdminDao.findById(adminDTO.getId())).thenReturn(optional);
		AdminDTO actual = iAdminService.update(adminDTO);
		Assertions.assertEquals(adminDTO, actual);
		
	}
	
	@Test
	void failedAdminUpdateTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		Mockito.when(iAdminDao.findById(adminDTO.getId())).thenReturn(null);
		AdminDTO actual = iAdminService.update(adminDTO);
		InvalidAdminException exception = Assertions.assertThrows(InvalidAdminException.class,() -> iAdminService.update(adminDTO));
		Assertions.assertEquals("Service.ADMIN_NOT_FOUND", exception.getMessage());
		
	}
	
	@Test
	void findByIdTest() throws InvalidAdminException{
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(1);
		adminDTO.setFirstName("John");
		adminDTO.setLastName("Jack");
		adminDTO.setPassword("123");
		Optional <Admin> optional = Optional.of(adminDTO.toAdmin());
		Mockito.when(iAdminDao.findById(1)).thenReturn(optional);
		AdminDTO actual = iAdminService.update(adminDTO);
		Assertions.assertEquals(actual, adminDTO);
		
	}
	
	@Test
	void failedFindByIdTest() throws InvalidAdminException{

		Mockito.when(iAdminDao.findById(1)).thenReturn(null);
		InvalidAdminException exception = Assertions.assertThrows(InvalidAdminException.class,() -> iAdminService.findById(1));
		Assertions.assertEquals("Service.ADMIN_NOT_FOUND", exception.getMessage());
		
	}

}
