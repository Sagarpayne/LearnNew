package com.sagarpayne.backend.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.sagarpayne.web.frontend.FeedbackPojo;


public interface EmailService {
	
	
	/**
	 * 
	 * @param feedbackPojo
	 */
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo);
	
	/**
	 *  generic EMail
	 * @param Msg
	 */
	public void sendGebericEmail(SimpleMailMessage Msg);

}
