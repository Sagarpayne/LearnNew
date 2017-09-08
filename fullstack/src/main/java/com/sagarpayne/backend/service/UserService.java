package com.sagarpayne.backend.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagarpayne.backend.persistence.domain.backend.Plan;
import com.sagarpayne.backend.persistence.domain.backend.User;
import com.sagarpayne.backend.persistence.domain.backend.UserRole;
import com.sagarpayne.backend.persistence.repositories.PlanRepository;
import com.sagarpayne.backend.persistence.repositories.RoleRepository;
import com.sagarpayne.backend.persistence.repositories.UserRepository;
import com.sagarpayne.enums.PlansEnum;
import com.sagarpayne.enums.RolesEnum;



@Service
@Transactional
public class UserService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Transactional
	public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {
		
		String encryptPassword =passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptPassword);
		
		Plan plan = new Plan(plansEnum);

		if (!planRepository.exists(plansEnum.getId())) {
			plan = planRepository.save(plan);
		}
		
		user.setPlan(plan);
		
		for(UserRole ur: userRoles)
		{
			roleRepository.save(ur.getRole());
		}
		
		user.getUserRoles().addAll(userRoles);
		
		user = userRepository.save(user);
		
		return user;
	}

}
