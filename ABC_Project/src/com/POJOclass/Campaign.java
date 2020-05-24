package com.POJOclass;

import java.util.Date;

public class Campaign {
	
	private int campaignID;
	private String campaignTitle;
	private String campaignDescription;
	private Date valid_from;
	private Date valid_to;
	private int ageOfRelationship;
	private double averageBalance;
	private String profession;
	
	

	public Campaign(int campaignID, String campaignTitle, String campaignDescription, Date valid_from, Date valid_to,
			int ageOfRelationship, double averageBalance, String profession) {
		super();
		this.campaignID = campaignID;
		this.campaignTitle = campaignTitle;
		this.campaignDescription = campaignDescription;
		this.valid_from = valid_from;
		this.valid_to = valid_to;
		this.ageOfRelationship = ageOfRelationship;
		this.averageBalance = averageBalance;
		this.profession = profession;
	}

	public int getCampaignID() {
		return campaignID;
	}

	public void setCampaignID(int campaignID) {
		this.campaignID = campaignID;
	}

	public int getAgeOfRelationship() {
		return ageOfRelationship;
	}

	public void setAgeOfRelationship(int ageOfRelationship) {
		this.ageOfRelationship = ageOfRelationship;
	}

	public double getAverageBalance() {
		return averageBalance;
	}

	public void setAverageBalance(double averageBalance) {
		this.averageBalance = averageBalance;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public Date getValid_to() {
		return valid_to;
	}



	public void setValid_to(Date valid_to) {
		this.valid_to = valid_to;
	}



	public String getCampaignTitle() {
		return campaignTitle;
	}
	public void setCampaignTitle(String campaignTitle) {
		this.campaignTitle = campaignTitle;
	}
	public String getCampaignDescription() {
		return campaignDescription;
	}
	public void setCampaignDescription(String campaignDescription) {
		this.campaignDescription = campaignDescription;
	}
	

}
