package com.POJO;

public class EmployeePOJO {
	
	private String name,username,password,desig;
	private int employee_id;
	private int role;
	
	

	public EmployeePOJO(String name, String username, String password, String desig, int employee_id, int role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.desig = desig;
		this.employee_id = employee_id;
		this.role = role;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	
	
	public EmployeePOJO()
	{
		
	}

}
