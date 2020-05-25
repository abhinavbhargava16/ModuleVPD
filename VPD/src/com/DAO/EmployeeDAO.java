package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
