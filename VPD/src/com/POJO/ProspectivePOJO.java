package com.POJO;

public class ProspectivePOJO {
	
	private int campaginID;
	private int customerID;
	private String customerName;
	private double balance;
	private int ageOfRelationship;
	private String status;
	private String phoneNumber;
	private int handlerId;
	private String Occupation;
	
	public String getOccupation() {
		return Occupation;
	}
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	public int getHandlerId() {
		return handlerId;
	}
	public void setHandlerId(int handlerId) {
		this.handlerId = handlerId;
	}
	public int getCampaginID() {
		return campaginID;
	}
	public void setCampaginID(int campaign) {
		this.campaginID = campaign;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAgeOfRelationship() {
		return ageOfRelationship;
	}
	public void setAgeOfRelationship(int ageOfRelationship) {
		this.ageOfRelationship = ageOfRelationship;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ProspectivePOJO(int campaginID, int customerID, String customerName, double balance, int ageOfRelationship,
			String status, String phoneNumber, int handlerId, String occupation) {
		super();
		this.campaginID = campaginID;
		this.customerID = customerID;
		this.customerName = customerName;
		this.balance = balance;
		this.ageOfRelationship = ageOfRelationship;
		this.status = status;
		this.phoneNumber = phoneNumber;
		this.handlerId = handlerId;
		Occupation = occupation;
	}
	public ProspectivePOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
