
package com.jobportal.service;

import com.jobportal.dto.AdminDTO;
import com.jobportal.exception.InvalidAdminException;


public interface IAdminService {
	
	public AdminDTO save (AdminDTO adminDTO) throws InvalidAdminException;
	public AdminDTO update (AdminDTO adminDTO) throws InvalidAdminException;
	public AdminDTO findById(int Id) throws InvalidAdminException;
	
	
}
