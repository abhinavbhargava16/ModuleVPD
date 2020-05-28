package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DBConnection.DBConnection;
import com.POJO.EmployeePOJO;


public class EmployeeDAO {
	
	public EmployeePOJO checkUser(Connection conn, String username, String password) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement("select * from employee where username=? and password=?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			EmployeePOJO t= new EmployeePOJO();
			t.setEmployee_id(rs.getInt(1));
			String name = rs.getString(2) + " " + rs.getString(4);
			t.setName(name);
			t.setUsername(rs.getString(7));
			t.setPassword(rs.getString(8));
			t.setDesig(rs.getString(5));
			t.setRole(rs.getInt(9));
			return t;
		}
		else {
			return null;
		}

}
	public ArrayList<EmployeePOJO> listAllSalesperson(Connection conn) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("select emp_id,emp_first_name,emp_last_name from employee where emp_role='2'");
		ResultSet rs = stmt.executeQuery();
		ArrayList<EmployeePOJO>empList = new ArrayList<EmployeePOJO>();
		while(rs.next()) {
			EmployeePOJO e = new EmployeePOJO();
			e.setEmployee_id(rs.getInt(1));
			String fullname = rs.getString(2)+" "+rs.getString(3);
			e.setName(fullname);
			empList.add(e);
		}
		return empList;
	}

	public ArrayList<EmployeePOJO> getAssignedSalesPerson(Connection conn) throws SQLException
	{
		PreparedStatement stmt = conn.prepareStatement("select emp_id,emp_first_name,emp_last_name from employee where emp_id in(select employee_id from prospective_customer)");
		ResultSet rs = stmt.executeQuery();
		ArrayList<EmployeePOJO> empList = new ArrayList<EmployeePOJO>();
		while(rs.next())
		{
			EmployeePOJO e = new EmployeePOJO();
			e.setEmployee_id(rs.getInt(1));
			String fullname = rs.getString(2)+ " " +rs.getString(3);
			e.setName(fullname);
			empList.add(e);
		}
		return empList;
		
	}
	public ArrayList<EmployeePOJO> listSalespersonCampaign(Connection conn,String campid) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME FROM EMPLOYEE WHERE EMP_ID IN (SELECT EMPLOYEE_ID FROM PROSPECTIVE_CUSTOMER WHERE CAMPAIGN_ID=?)");
		stmt.setString(1, campid); 
		ResultSet rs = stmt.executeQuery();
		ArrayList<EmployeePOJO>empList = new ArrayList<EmployeePOJO>();
		while(rs.next()) {
			EmployeePOJO e = new EmployeePOJO();
			e.setEmployee_id(rs.getInt(1));
			String fullname = rs.getString(2)+" "+rs.getString(3);
			e.setName(fullname);
			empList.add(e);
		}
		return empList;
		
	}
}
