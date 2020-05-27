package com.POJO;

import java.util.Date;

public class CampaignPOJO {
	
	private String campaignID;
	private String campaignTitle;
	private String campaignDescription;
	private Date valid_from;
	private Date valid_to;
	private int ageOfRelationship;
	private double averageBalance;
	private String profession;
	private int emp_id;
	
	

	public CampaignPOJO(String campaignID, String campaignTitle, String campaignDescription, Date valid_from,
			Date valid_to, int ageOfRelationship, double averageBalance, String profession, int emp_id) {
		super();
		this.campaignID = campaignID;
		this.campaignTitle = campaignTitle;
		this.campaignDescription = campaignDescription;
		this.valid_from = valid_from;
		this.valid_to = valid_to;
		this.ageOfRelationship = ageOfRelationship;
		this.averageBalance = averageBalance;
		this.profession = profession;
		this.emp_id = emp_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getCampaignID() {
		return campaignID;
	}

	public void setCampaignID(String campaignID) {
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

	public CampaignPOJO() {
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
