
package com.jobportal.service;

import com.jobportal.dto.AdminDTO;


public interface IAdminService {
	
	public AdminDTO save (AdminDTO adminDTO) throws Exception;
	public AdminDTO update (AdminDTO adminDTO) throws Exception;
	public AdminDTO findById(int Id) throws Exception;
	
	
}
