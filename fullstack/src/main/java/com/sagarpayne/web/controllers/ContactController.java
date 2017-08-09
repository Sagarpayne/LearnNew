package com.sagarpayne.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarpayne.backend.service.EmailService;
import com.sagarpayne.web.frontend.FeedbackPojo;




@Controller

public class ContactController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
	
	public static final String FEEDBACK_MODEL_KEY="feedback";
	
	private static final String CONTACT_US_VIEW_NAME="contact/contact";
	
	@Autowired
	private EmailService emailService;
	
	
	/**
	 * Contact , get request handler
	 * @param model , New feedback model
	 * @return Contact Page
	 */
	@RequestMapping(value="/contact",method =RequestMethod.GET)
	public String contactGet(ModelMap model)
	{
		FeedbackPojo feedbackPojo= new FeedbackPojo();
		model.addAttribute(ContactController.FEEDBACK_MODEL_KEY,feedbackPojo);
		return CONTACT_US_VIEW_NAME;
		
	}
	
	/**
	 * 
	 * @param feedback
	 * @return
	 */
	@RequestMapping(value="/contact",method =RequestMethod.POST)
	public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback)
	{
		
		LOG.debug("FeedbackPojo : {} ",feedback);
		emailService.sendFeedbackEmail(feedback);
		return "/index";
		
	}

}
