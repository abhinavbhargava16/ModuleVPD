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

import com.dao.InsertCampaignDAO;


@WebServlet("/InsertCampaign")
public class InsertCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Date from;
	private java.sql.Date to;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter obj = response.getWriter();
		String campaignTitle = request.getParameter("campaignTitle");
		String campaignDescription = request.getParameter("campaignDescription");
		String valid_from = request.getParameter("valid_from");
		String valid_to = request.getParameter("valid_to");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		InsertCampaignDAO insert = new InsertCampaignDAO();
		try {
			Date from_date = sdf.parse(valid_from);
			Date to_date = sdf1.parse(valid_to);
			insert.setUser(campaignTitle, campaignDescription, from_date, to_date);
		} catch (ParseException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
