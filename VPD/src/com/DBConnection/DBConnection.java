package com.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		ResourceBundle rb =ResourceBundle.getBundle("mydb");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}

}
