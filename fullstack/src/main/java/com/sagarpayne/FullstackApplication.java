package com.sagarpayne;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sagarpayne.backend.persistence.domain.backend.Role;
import com.sagarpayne.backend.persistence.domain.backend.User;
import com.sagarpayne.backend.persistence.domain.backend.UserRole;
import com.sagarpayne.backend.service.UserSecurityService;
import com.sagarpayne.backend.service.UserService;
import com.sagarpayne.enums.PlansEnum;
import com.sagarpayne.enums.RolesEnum;
import com.sagarpayne.utils.UserUtils;

@SpringBootApplication
public class FullstackApplication implements CommandLineRunner{

	private static final Logger LOG= org.slf4j.LoggerFactory.getLogger(FullstackApplication.class);
	
	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception
	{
	User user = UserUtils.createBasicUser("basic", "mo@gmail.com");
		
	Set<UserRole> userRoles = new HashSet<>();
	userRoles.add(new UserRole(user, new Role(RolesEnum.PRO)));
	LOG.debug("Creating user with username {} " , user.getUsername());
	userService.createUser(user, PlansEnum.PRO, userRoles);
	LOG.debug("user {} Created " , user.getUsername());
	
	
	}
	
	
}
