package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.POJOclass.Campaign;
import com.POJOclass.CampaignCriteria;
import com.dao.InsertCampaignDAO;


@WebServlet("/InsertCampaign")
public class InsertCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Date from;
	private java.sql.Date to;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		InsertCampaignDAO icd = new InsertCampaignDAO();
		try
		{
			
			Campaign obj = new Campaign();
			obj.setCampaignTitle(request.getParameter("campaignTitle"));
			obj.setCampaignDescription(request.getParameter("campaignDescription"));
			obj.setValid_from(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_from")));
			obj.setValid_to(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_to")));
			icd.insertCampaign(obj);

		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			CampaignCriteria ccobj = new CampaignCriteria();
			ccobj.setAgeOfRelationship(request.getParameter("ageOfRelationship"));
			ccobj.setAverageBalance(request.getParameter("averagebalance"));
			ccobj.setProfession(request.getParameter("profession"));
			icd.insertCampaignCriteria(ccobj);
			
		}
		catch(Exception e)
		{
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
