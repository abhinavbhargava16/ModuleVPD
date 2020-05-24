package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.POJOclass.Campaign;
import com.dao.InsertCampaignDAO;

public class FindCampaignDAO {
	
	public Campaign findCampaign(Connection conn, String id) throws SQLException
	{
		PreparedStatement st = conn.prepareStatement("select a.campaign_id,a.campaign_title,a.description,a.valid_from,a.valid_to,b.age_of_relationship,b.min_balance,b.profession from campaign a,campaign_criteria b where a.campaign_id=b.campaign_id and a.campaign_id=?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next())
		{
			Campaign temp = new Campaign();
			temp.setCampaignID(rs.getInt(1));
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

}
