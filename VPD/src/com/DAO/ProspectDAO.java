package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.POJO.CampaignPOJO;
import com.POJO.ProspectivePOJO;


public class ProspectDAO {
	public ArrayList<ProspectivePOJO> listUnassignedProspective(Connection conn,CampaignPOJO poj ) throws SQLException{
		double avg = poj.getAverageBalance();
		int age = poj.getAgeOfRelationship();
		String prof = poj.getProfession();
		PreparedStatement stmt;
		if(prof.equals("ANY")) {
			stmt = conn.prepareStatement("select a.customer_id,a.cust_first_name,a.cust_last_name,floor((SYSDATE-a.relationship_start_date)/365),b.balance,b.mobile_num from customer a join account b on a.preferred_acc_1 = b.account_number where (sysdate-a.relationship_start_date/365>=? and b.balance>=? and a.customer_id not in(select customer_id from prospective_customer)");
			stmt.setInt(1, age);
			stmt.setDouble(2, avg);
		}
		else {
			stmt = conn.prepareStatement("SELECT A.CUSTOMER_ID,A.CUST_FIRST_NAME,A.CUST_LAST_NAME,FLOOR((SYSDATE-A.RELATIONSHIP_START_DATE)/365),B.BALANCE,B.MOBILE_NUM FROM CUSTOMER A JOIN ACCOUNT B ON A.PREFERRED_ACC_1 = B.ACCOUNT_NUMBER WHERE A.OCCUPATION=? AND (SYSDATE-A.RELATIONSHIP_START_DATE)/365>=? AND B.BALANCE>=? AND A.CUSTOMER_ID NOT IN(SELECT CUSTOMER_ID FROM PROSPECTIVE_CUSTOMER)");
			stmt.setString(1, prof);
			stmt.setInt(2, age);
			stmt.setDouble(3, avg);
			
			
		}

	ResultSet rs = stmt.executeQuery();
	ArrayList<ProspectivePOJO>myList=new ArrayList<ProspectivePOJO>();
	while(rs.next()) {
		ProspectivePOJO temp = new ProspectivePOJO();
		String name = rs.getString(2)+" "+rs.getString(3);
		temp.setCampaginID(poj.getCampaignID());
		temp.setCustomerID(rs.getInt(1));
		temp.setCustomerName(name);
		temp.setAgeOfRelationship(rs.getInt(4));
		temp.setBalance(rs.getDouble(5));
		temp.setPhoneNumber(rs.getString(6));
		myList.add(temp);
	}
	return myList;
}
	public ArrayList<ProspectivePOJO> selectProspect(Connection conn, String id) throws SQLException
	{
		PreparedStatement stmt = conn.prepareStatement("SELECT A.CUSTOMER_ID,A.CAMPAIGN_ID,B.CUST_FIRST_NAME,B.CUST_LAST_NAME,B.MOBILE_NUM,A.STATUS FROM CUSTOMER B JOIN PROSPECTIVE_CUSTOMER A ON B.CUSTOMER_ID = A.CUSTOMER_ID WHERE A.EMPLOYEE_ID=?");
		stmt.setString(1,id);
		ResultSet rs = stmt.executeQuery();
		ArrayList<ProspectivePOJO>myList=new ArrayList<ProspectivePOJO>();
		while(rs.next())
		{
			ProspectivePOJO temp = new ProspectivePOJO();
			temp.setCustomerID(rs.getInt(1));
			Integer cid = Integer.parseInt(rs.getString(2));
			temp.setCampaginID(cid);
			String name = rs.getString(3)+ " " +rs.getString(4);
			temp.setCustomerName(name);
			temp.setPhoneNumber(rs.getString(5));
			temp.setStatus(rs.getString(6));
			
			myList.add(temp);
			
		}
		return null;
		
	}
	public void insertProspective(Connection conn, ProspectivePOJO prospect) throws SQLException
	{
		PreparedStatement stmt = conn.prepareStatement("insert into prospective_customer values(?,?,?,'Assigned',null)");
		stmt.setInt(1, prospect.getCustomerID());
		stmt.setInt(2, prospect.getCampaginID());
		stmt.setInt(3,prospect.getHandlerId());
		stmt.execute();
		
		stmt = conn.prepareStatement("insert into status values(pro_status_id.nextval,?,sysdate,'Assigned',null)");
		stmt.setInt(1, prospect.getCustomerID());
		stmt.execute();	
	}
	public void updateProspectiveAssign(Connection conn, int emp_id,int cust_id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE PROSPECTIVE_CUSTOMER SET EMPLOYEE_ID=? WHERE CUSTOMER_ID=?");
		stmt.setInt(1, emp_id);
		stmt.setInt(2, cust_id);
		stmt.execute();
		
		stmt = conn.prepareStatement("INSERT INTO STATUS VALUES(PRO_STATUS_ID.NEXTVAL,?,SYSDATE,'REASSIGNED',NULL)");
		stmt.setInt(1,cust_id); 
		stmt.execute();
		
		
	}
	public int countAllProspective(Connection conn,CampaignPOJO camp ) throws SQLException {
		
		PreparedStatement stmt = conn.prepareStatement("select * from prospective_customer where campaign_id=?");
		stmt.setString(1,Integer.toString(camp.getCampaignID()));
		ResultSet rs = stmt.executeQuery();
		int count = 0;
		while(rs.next()) {
			count++;
		}
		return count;
	}
	public ProspectivePOJO getDetails(Connection conn, String custID) throws SQLException
	{
		PreparedStatement stmt = conn.prepareStatement("Select a.customer_id,a.campaign_id,b.cust_first_name,b.cust_last_name,"
				+"b.mobile_num,a.status, FLOOR((SYSDATE-b.relationship_start_date)/365), b.occupation,c.balance from account c join customer b on b.preferred_acc_1 = c.account_number join prospective_customer a on b.customer_id = a.customer_id where a.customer_id=?");							
		stmt.setString(1, custID);
		ResultSet rs = stmt.executeQuery();
		ProspectivePOJO temp = new ProspectivePOJO();
		if(rs.next())
		{
			temp.setCustomerID(rs.getInt(1));
			temp.setCampaginID(rs.getInt(2));
			String name = rs.getString(3) + " " + rs.getString(4);
			temp.setCustomerName(name);
			temp.setPhoneNumber(rs.getString(5));
			temp.setStatus(rs.getString(6));
			temp.setAgeOfRelationship(rs.getInt(7));
			temp.setOccupation(rs.getString(8));
			temp.setBalance(rs.getDouble(9));
			
		}
		return temp;
		
	}
	
}
