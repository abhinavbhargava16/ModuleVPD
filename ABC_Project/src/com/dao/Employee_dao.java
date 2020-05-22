package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.POJOclass.Employee;
import com.DBConnection.*;



public class Employee_dao {
	
	public Employee checkUser(String s) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from employee where username=?");
		stmt.setString(1, s);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			Employee t= new Employee();
			t.setUsername(rs.getString(1));
			t.setPassword(rs.getString(2));
			t.setUserid(rs.getInt(3));
			return t;
		}
		else {
			return null;
		}

}
}
