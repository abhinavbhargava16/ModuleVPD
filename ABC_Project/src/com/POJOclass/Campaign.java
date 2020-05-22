package com.POJOclass;

import java.util.Date;

public class Campaign {
	
	private String campaignTitle;
	private String campaignDescription;
	private Date valid_from;
	private Date valid_to;
	
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
