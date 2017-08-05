package com.sagarpayne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.sagarpayne.backend.service.EmailService;
import com.sagarpayne.backend.service.SmtpEmailService;

@Configuration
@Profile("prod")
@PropertySource("application-prod.properties")
public class ProductionConfig {

	@Bean
	public EmailService emailSevice() 
	{
		return new SmtpEmailService();
	}
}
