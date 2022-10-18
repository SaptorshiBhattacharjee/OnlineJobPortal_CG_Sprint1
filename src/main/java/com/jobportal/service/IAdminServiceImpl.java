
package com.jobportal.service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.AdminDTO;
import com.jobportal.entity.Admin;
import com.jobportal.exception.InvalidAdminException;
import com.jobportal.repository.IAdminDao;

@Service(value="iAdminService")
@Transactional
public class IAdminServiceImpl implements IAdminService{
	
	
	@Autowired
	IAdminDao iAdminDao;
	
	
	
	@Override
	public AdminDTO save(AdminDTO adminDTO) throws InvalidAdminException {
		
		Admin admin = adminDTO.toAdmin();
		iAdminDao.save(admin);
		return adminDTO;
	}

	@Override
	public AdminDTO update(AdminDTO adminDTO) throws InvalidAdminException{
		Optional<Admin> optional = iAdminDao.findById(adminDTO.getId());
		Admin admin1 = optional.orElseThrow(() -> new InvalidAdminException("Service.ADMIN_NOT_FOUND"));
		admin1.setFirstName(adminDTO.getFirstName());
		admin1.setLastName(adminDTO.getLastName());
		admin1.setPassword(adminDTO.getPassword());
		return adminDTO;
	}

	@Override
	public AdminDTO findById(int Id) throws InvalidAdminException{
		Optional<Admin> optional = iAdminDao.findById(Id);
		Admin admin = optional.orElseThrow(() -> new InvalidAdminException("Service.ADMIN_NOT_FOUND"));
		AdminDTO adminDTO = new AdminDTO();
		adminDTO = admin.toAdminDTO();
		return adminDTO;
		
	}
	
}

