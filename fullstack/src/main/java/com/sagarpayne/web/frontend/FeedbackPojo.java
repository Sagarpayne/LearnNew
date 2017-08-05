package com.sagarpayne.web.frontend;

import java.io.Serializable;

public class FeedbackPojo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String fName;
	private String lName;
	private String feedback;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "FeedbackPojo [email=" + email + ", fName=" + fName + ", lName=" + lName + ", feedback=" + feedback
				+ "]";
	}

}
