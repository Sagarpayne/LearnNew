package com.sagarpayne.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

public class SmtpEmailService extends AbstractEmailService {

	private static final Logger LOG= LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Override
	public void sendGebericEmail(SimpleMailMessage Msg) {
		
		LOG.debug("Sending Mail");
		mailSender.send(Msg);
		LOG.info("Email Sent ...!!");
		// TODO Auto-generated method stub
		
	}

}
