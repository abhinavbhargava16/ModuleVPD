package com.POJOclass;

public class Employee {
	
	String username,password,desig;

	public Employee(String username, String password, String desig) {
		super();
		this.username = username;
		this.password = password;
		this.desig = desig;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
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

	
	
	public Employee()
	{
		
	}

}
