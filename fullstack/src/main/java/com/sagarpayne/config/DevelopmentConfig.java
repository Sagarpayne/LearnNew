package com.sagarpayne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.sagarpayne.backend.service.EmailService;
import com.sagarpayne.backend.service.MockEmailService;

@Configuration
@Profile("dev")
@PropertySource("application-dev.properties")
public class DevelopmentConfig {
	
	@Bean
	public EmailService emailService () {
		
		return new MockEmailService();
	}

}