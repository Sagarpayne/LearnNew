package com.sagarpayne.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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
	
	@Bean
	public ServletRegistrationBean h2ConsoleServletRegistration()
	{
		ServletRegistrationBean bean= new ServletRegistrationBean(new WebServlet());
		bean.addUrlMappings("/console/*");
		return bean;
				
	}

}
