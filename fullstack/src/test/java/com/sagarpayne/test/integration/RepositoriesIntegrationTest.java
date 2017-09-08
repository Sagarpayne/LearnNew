package com.sagarpayne.test.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;

import com.sagarpayne.FullstackApplication;
import com.sagarpayne.backend.persistence.domain.backend.Plan;
import com.sagarpayne.backend.persistence.domain.backend.Role;
import com.sagarpayne.backend.persistence.domain.backend.User;
import com.sagarpayne.backend.persistence.repositories.PlanRepository;
import com.sagarpayne.backend.persistence.repositories.RoleRepository;
import com.sagarpayne.backend.persistence.repositories.UserRepository;
import com.sagarpayne.enums.PlansEnum;
import com.sagarpayne.enums.RolesEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest

public class RepositoriesIntegrationTest {

	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private UserRepository userRepository;

	private static final int BASIC_PLAN_ID = 1;
	private static final int BASIC_ROLE_ID = 1;
	private static final int BASIC_USER_ID = 1;
	
	@Before
	public void init()
	{
		Assert.assertNotNull(planRepository);
		Assert.assertNotNull(roleRepository);
		Assert.assertNotNull(userRepository);
	}
	
	@Test
	public void testCreateNewPlan() throws Exception
	{
		Plan basicPlan =createBasicPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan);
		Plan receivedPlan = planRepository.findOne(BASIC_PLAN_ID);
		Assert.assertNotNull(receivedPlan);
		
	}
	
	@Test
	public void testCreateNewRole() throws Exception
	{
		Role userRole =createRole(RolesEnum.BASIC);
		roleRepository.save(userRole);
		
		Role retrivedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
		Assert.assertNotNull(retrivedRole);
				
	}
	
	private Plan createBasicPlan(PlansEnum ep)
	{
		Plan plan= new Plan(ep);
		
		return plan;
		
	}
	
	private Role createRole(RolesEnum re)
	{
		return new Role(re);
		
	}

	private User CreateBasicUser() 
	{
		User user = new User();
		
<<<<<<< HEAD
		
		
		return user;
		
=======
		return user;
>>>>>>> c42d8796b4834b9099058aaf50115b657898808d
	}
	
}
