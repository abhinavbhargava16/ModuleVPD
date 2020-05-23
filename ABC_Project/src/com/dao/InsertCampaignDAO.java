package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DBConnection.DBConnection;
import com.POJOclass.Campaign;
import com.POJOclass.CampaignCriteria;

public class InsertCampaignDAO {

	public void insertCampaign(Campaign obj) throws ClassNotFoundException, SQLException
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps =conn.prepareStatement("insert into campaign values(campaign_id_sequence.nextval,?,?,?,?");
		ps.setString(2,obj.getCampaignTitle() );
		ps.setString(3,obj.getCampaignDescription());
		ps.setDate(4,new Date(obj.getValid_from().getTime()));
		ps.setDate(5,new Date(obj.getValid_to().getTime()));
		ps.executeUpdate();
		ps.close();		
	}
	public void insertCampaignCriteria(CampaignCriteria obj) throws ClassNotFoundException, SQLException
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps =conn.prepareStatement("insert into campaign_criteria values(?,?,?,campaign_id_sequence.currval");
		ps.setString(1, obj.getAgeOfRelationship());
		ps.setString(2, obj.getAverageBalance());
		ps.setString(3, obj.getProfession());
		
		ps.executeUpdate();
		ps.close();
	}
}
