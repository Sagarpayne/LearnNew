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
import com.sagarpayne.backend.persistence.domain.backend.User;
import com.sagarpayne.backend.persistence.repositories.PlanRepository;
import com.sagarpayne.backend.persistence.repositories.RoleRepository;
import com.sagarpayne.backend.persistence.repositories.UserRepository;

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
		Plan basicPlan =createBasicPlan();
		planRepository.save(basicPlan);
		Plan receivedPlan = planRepository.findOne(BASIC_PLAN_ID);
		Assert.assertNotNull(receivedPlan);
		
	}
	
	private Plan createBasicPlan()
	{
		Plan plan= new Plan();
		plan.setId(BASIC_PLAN_ID);
		plan.setName("Basic");
		return plan;
		
	}

	private User CreateBasicUser() 
	{
		User user = new User();
		
		
	}
	
}
