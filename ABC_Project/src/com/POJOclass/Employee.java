package com.POJOclass;

public class Employee {
	
	String username,password;
	int userid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(String username, String password,int userid) {
		super();
		this.username = username;
		this.password = password;
		this.userid=userid;
	}
	
	public Employee()
	{
		
	}

}
