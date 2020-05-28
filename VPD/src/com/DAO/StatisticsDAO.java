package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsDAO {
	public static int getProspect(Connection conn,int id,String campid) throws SQLException {
		int x = 0;
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PROSPECTIVE_CUSTOMER WHERE EMPLOYEE_ID=? AND CAMPAIGN_ID=? AND STATUS='Assigned'");
		stmt.setInt(1, id);
		stmt.setString(2, campid);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int getFollowUps(Connection conn,int id,String campid) throws SQLException {
		int x = 0;
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PROSPECTIVE_CUSTOMER WHERE EMPLOYEE_ID=? AND CAMPAIGN_ID=? AND STATUS='Follow-up in progress'");
		stmt.setInt(1, id);
		stmt.setString(2, campid);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int getNotInterested(Connection conn,int id,String campid) throws SQLException {
		int x = 0;
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PROSPECTIVE_CUSTOMER WHERE EMPLOYEE_ID=? AND CAMPAIGN_ID=? AND STATUS='Not interested'");
		stmt.setInt(1, id);
		stmt.setString(2, campid);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int getCommitted(Connection conn,int id,String campid) throws SQLException {
		int x = 0;
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PROSPECTIVE_CUSTOMER WHERE EMPLOYEE_ID=? AND CAMPAIGN_ID=? AND STATUS='Committed'");
		stmt.setInt(1, id);
		stmt.setString(2, campid);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			x++;
		}
		return x;
	}

}
