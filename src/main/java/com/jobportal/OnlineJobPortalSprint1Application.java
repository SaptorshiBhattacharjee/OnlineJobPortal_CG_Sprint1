package com.jobportal;


<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
>>>>>>> branch 'main' of https://github.com/SaptorshiBhattacharjee/OnlineJobPortal_CG_Sprint1.git
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

<<<<<<< HEAD
import com.jobportal.service.ISkillService;
=======
import com.jobportal.dto.FreelancerDTO;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.IFreelancerService;
import com.jobportal.service.IRecruiterService;
>>>>>>> branch 'main' of https://github.com/SaptorshiBhattacharjee/OnlineJobPortal_CG_Sprint1.git



@SpringBootApplication
<<<<<<< HEAD
public class OnlineJobPortalSprint1Application {
=======
public class OnlineJobPortalSprint1Application implements CommandLineRunner {
	
	public static final Log LOGGER = LogFactory.getLog(OnlineJobPortalSprint1Application.class);

	
	@Autowired
	private IFreelancerService iFreelancerService;

	@Autowired
	Environment environment;

>>>>>>> branch 'main' of https://github.com/SaptorshiBhattacharjee/OnlineJobPortal_CG_Sprint1.git
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineJobPortalSprint1Application.class, args);
	}
	
<<<<<<< HEAD
	public void run(String...args) {
		
	}
}
=======
	
	public  void run(String...args) {
		
		
		
	}
	}
	

>>>>>>> branch 'main' of https://github.com/SaptorshiBhattacharjee/OnlineJobPortal_CG_Sprint1.git
