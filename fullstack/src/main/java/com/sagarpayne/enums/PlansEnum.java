package com.sagarpayne.enums;

public enum PlansEnum {

	BASIC(1,"ROLE_BASIC"),
	PRO(2,"ROLE_PRO");
	
	
	
	private final int id;
	
	private final String planName;
	
	PlansEnum(int id,String planName)
	{
		this.id=id;
		this.planName=planName;
	}
	
	public int getId(){return id;}
	
	public String getPlanName(){return planName;}
}
