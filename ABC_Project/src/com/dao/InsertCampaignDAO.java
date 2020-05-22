package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DBConnection.DBConnection;
import com.POJOclass.Campaign;

public class InsertCampaignDAO {

	public void setUser(String s1,String s2, java.util.Date from_date, java.util.Date to_date) throws ClassNotFoundException, SQLException
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps =conn.prepareStatement("insert into campaign values(campaign_id_sequence.nextval,?,?,?,?");
		ps.setString(2,s1 );
		ps.setString(3,s2);
		ps.setDate(4,(Date) from_date);
		ps.setDate(5,(Date) to_date);
		ps.executeUpdate();
		ps.close();		
	}
}
