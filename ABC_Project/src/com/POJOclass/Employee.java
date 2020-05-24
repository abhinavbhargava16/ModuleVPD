package com.POJOclass;

public class Employee {
	
	private String name,username,password,desig;
	private int employee_id;
	
	public Employee(String name, String username, String password, String desig, int employee_id) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.desig = desig;
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
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
