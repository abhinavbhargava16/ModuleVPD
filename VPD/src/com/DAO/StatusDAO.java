package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.POJO.StatusPOJO;



public class StatusDAO {
	public ArrayList<StatusPOJO>custStatus(Connection conn,String custId) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM STATUS WHERE CUSTOMER_ID=? ORDER BY UPDATED_DATE");
		stmt.setString(1, custId);
		ResultSet rs = stmt.executeQuery();
		ArrayList<StatusPOJO> l = new ArrayList<StatusPOJO>();
		while(rs.next()) {
			StatusPOJO temp = new StatusPOJO();
			temp.setDatestamp(rs.getDate(3));
			temp.setStatus(rs.getString(4));
			l.add(temp);
		}
		System.out.println(l.size());
		return l;
	}
	
	public void updateStatus(Connection conn, String custId,String stat) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE PROSPECTIVE_CUSTOMER SET STATUS=? WHERE CUSTOMER_ID=?");
		stmt.setString(1, stat);
		stmt.setString(2, custId);
		stmt.executeUpdate();
		
		stmt = conn.prepareStatement("INSERT INTO STATUS VALUES(PRO_STATUS_ID.NEXTVAL,?,SYSDATE,?,NULL)");
		stmt.setString(1,custId);
		stmt.setString(2, stat);
		stmt.execute();
	}

}