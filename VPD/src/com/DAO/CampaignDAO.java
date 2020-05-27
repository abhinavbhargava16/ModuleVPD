package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import com.POJO.CampaignPOJO;
import com.POJO.EmployeePOJO;


public class CampaignDAO {

	public void insertCampaign(Connection conn,CampaignPOJO obj,EmployeePOJO employee_id) throws ClassNotFoundException, SQLException
	{
	
		PreparedStatement ps =conn.prepareStatement("insert into campaign values(campaign_id_sequence.nextval,?,?,?,?,?)");
		ps.setString(1,obj.getCampaignTitle() );
		ps.setString(2,obj.getCampaignDescription());
		ps.setDate(3,new Date(obj.getValid_from().getTime()));
		ps.setDate(4,new Date(obj.getValid_to().getTime()));
		ps.setInt(5, employee_id.getEmployee_id());
		ps.executeUpdate();
			
		
		ps =conn.prepareStatement("insert into campaign_criteria values(?,?,?,campaign_id_sequence.currval,?)");
		ps.setInt(1, obj.getAgeOfRelationship());
		ps.setDouble(2, obj.getAverageBalance());
		ps.setString(3, obj.getProfession());
		ps.setInt(4, employee_id.getEmployee_id());
		ps.execute();
		
		ps=conn.prepareStatement("insert into campaign_log values(campaign_id_sequence.currval,?,?,?)");
		ps.setInt(1,employee_id.getEmployee_id());
		ps.setTimestamp(2, new Timestamp(Calendar.getInstance().getTime().getTime()));
		ps.setString(3, "Campaign Created");
		ps.execute();
		
	}
	
	public ArrayList<CampaignPOJO> listCampaign(Connection conn) throws SQLException{
		ArrayList<CampaignPOJO> myList = new ArrayList<CampaignPOJO>();
		PreparedStatement stmt = conn.prepareStatement("select a.campaign_id,a.campaign_title,a.description,a.valid_from,a.valid_to,b.age_of_relationship,b.min_balance,b.profession from campaign a,campaign_criteria b where a.campaign_id=b.campaign_id");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			CampaignPOJO temp = new CampaignPOJO();
			temp.setCampaignID(rs.getString(1));
			temp.setCampaignTitle(rs.getString(2));
			temp.setCampaignDescription(rs.getString(3));
			temp.setValid_from(rs.getDate(4));
			temp.setValid_to(rs.getDate(5));
			temp.setAgeOfRelationship(rs.getInt(6));
			temp.setAverageBalance(rs.getDouble(7));
			temp.setProfession(rs.getString(8));
			myList.add(temp);
			
		}
		return myList;
	}
	
	public CampaignPOJO findCampaign(Connection conn, String id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select a.campaign_id ,a.campaign_title,a.description,a.valid_from,a.valid_to,b.age_of_relationship,b.min_balance,b.profession from campaign a,campaign_criteria b where a.campaign_id=b.campaign_id and a.campaign_id=?");
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			CampaignPOJO temp = new CampaignPOJO();
			temp.setCampaignID(rs.getString(1));
			temp.setCampaignTitle(rs.getString(2));
			temp.setCampaignDescription(rs.getString(3));
			temp.setValid_from(rs.getDate(4));
			temp.setValid_to(rs.getDate(5));
			temp.setAgeOfRelationship(rs.getInt(6));
			temp.setAverageBalance(rs.getDouble(7));
			temp.setProfession(rs.getString(8));
			return temp;
		}
		return null;
	}
	public void updateCampaign(Connection conn, String id, java.util.Date from, java.util.Date to) throws SQLException {
		System.out.println("Inside update campaign");
		PreparedStatement stmt = conn.prepareStatement("update campaign set valid_from=?,valid_to where campaign_id=?");
		System.out.println("after prepare statement");
		stmt.setDate(1, new Date(from.getTime()));
		stmt.setDate(2, new Date(to.getTime()));
		stmt.setString(3, id);
		stmt.execute();
		stmt = conn.prepareStatement("INSERT INTO CAMPAIGN_LOG VALUES(campaign_id_sequence.currval,?,?,?)");
		stmt.setString(1, id);
		stmt.setTimestamp(2, new Timestamp(Calendar.getInstance().getTime().getTime()));
		stmt.setString(3, "Campaign Updated");
		stmt.execute();
		
	}
	
}
