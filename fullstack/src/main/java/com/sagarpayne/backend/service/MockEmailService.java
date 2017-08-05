package com.sagarpayne.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	@Override
	public void sendGebericEmail(SimpleMailMessage Msg) {
		
		LOG.debug("Sim Email Service");
		LOG.info(Msg.toString());
		
		LOG.debug("Email Sent .....!");
	}
	
	

}
