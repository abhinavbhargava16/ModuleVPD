package com.POJOclass;

public class CampaignCriteria {

	private String ageOfRelationship;
	private String averageBalance;
	private String profession;
	
	public String getAverageBalance() {
		return averageBalance;
	}
	public void setAverageBalance(String averageBalance) {
		this.averageBalance = averageBalance;
	}
	public String getAgeOfRelationship() {
		return ageOfRelationship;
	}
	public void setAgeOfRelationship(String ageOfRelationship) {
		this.ageOfRelationship = ageOfRelationship;
	}
	
	
	
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public CampaignCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
