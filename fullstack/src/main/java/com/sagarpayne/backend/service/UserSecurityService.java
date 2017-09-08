package com.sagarpayne.backend.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sagarpayne.backend.persistence.domain.backend.User;
import com.sagarpayne.backend.persistence.repositories.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {

	private static final Logger LOG= org.slf4j.LoggerFactory.getLogger(UserSecurityService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if(null == user)
		{
			LOG.warn("Username {} not found",username);
			throw new UsernameNotFoundException("Username" + username + " not found");
		}
		
		return user;
	}

	
}
