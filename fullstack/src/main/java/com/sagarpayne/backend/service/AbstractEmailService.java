package com.sagarpayne.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.sagarpayne.web.frontend.FeedbackPojo;



public abstract class AbstractEmailService implements EmailService {

	@Value("${default.to.address}")
	private String defaultAddress;
	
	protected SimpleMailMessage perpareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedbackPojo)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(defaultAddress);
		message.setFrom(feedbackPojo.getEmail());
		message.setSubject("Feedback Receiced from" + feedbackPojo.getfName()  +"!!");
		message.setText(feedbackPojo.getFeedback());
		
		return message;
	}
	
	@Override
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo)
	{
		 sendGebericEmail(perpareSimpleMailMessageFromFeedbackPojo(feedbackPojo));
		
	}
}
