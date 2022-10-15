
package com.jobportal.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.AdminDTO;
import com.jobportal.entity.Admin;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.IAdminDao;
import com.jobportal.service.IAdminService;
@Service(value="iAdminService")
@Transactional
public class IAdminServiceImpl implements IAdminService{
	
	
	@Autowired
	IAdminDao iAdminDao;
	
	
	
	@Override
	public AdminDTO save(AdminDTO adminDTO) throws JobPortalException {
		
		Admin admin = new Admin();
		admin.setFirstName(adminDTO.getFirstName());
		admin.setLastName(adminDTO.getLastName());
		admin.setPassword(adminDTO.getPassword());
		iAdminDao.save(admin);
		return adminDTO;
	}

	@Override
	public AdminDTO update(AdminDTO adminDTO) throws Exception{
		Optional<Admin> optional = iAdminDao.findById(adminDTO.getId());
		Admin admin1 = optional.orElseThrow(() -> new JobPortalException("Service.ADMIN_NOT_FOUND"));
		admin1.setFirstName(adminDTO.getFirstName());
		admin1.setLastName(adminDTO.getLastName());
		admin1.setPassword(adminDTO.getPassword());
		return adminDTO;
	}

	@Override
	public AdminDTO findById(int Id) throws Exception{
		Optional<Admin> optional = iAdminDao.findById(Id);
		Admin admin = optional.orElseThrow(() -> new JobPortalException("Service.ADMIN_NOT_FOUND"));
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(admin.getId());
		adminDTO.setFirstName(admin.getFirstName());
		adminDTO.setLastName(admin.getLastName());
		adminDTO.setPassword(admin.getPassword());
		return adminDTO;
		
	}
	
}

