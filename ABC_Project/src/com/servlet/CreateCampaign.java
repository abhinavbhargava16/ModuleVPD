package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.POJOclass.Campaign;
import com.dao.InsertCampaignDAO;


@WebServlet("/CreateCampaign")
public class CreateCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		InsertCampaignDAO icd = new InsertCampaignDAO();
		out.println("Inside Campaign");
		try
		{
			System.out.println("inside campaign");
			out.println("Inside Campaign");
			Campaign obj = new Campaign();
			obj.setCampaignTitle(request.getParameter("campaignTitle"));
			obj.setCampaignDescription(request.getParameter("campaignDescription"));
			obj.setValid_from(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_from")));
			obj.setValid_to(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_to")));
			obj.setAgeOfRelationship(Integer.parseInt(request.getParameter("ageOfRelationship")));
			obj.setAverageBalance(Double.parseDouble(request.getParameter("averagebalance")));
			obj.setProfession(request.getParameter("profession"));
			
			ServletContext context = request.getServletContext();
			Connection conn = (Connection) context.getAttribute("connection");
			icd.insertCampaign(conn,obj);
			
			out.println("New Campaign Created");
			request.getRequestDispatcher("Campaign_Menu.jsp").include(request, response);

		}
		catch (ParseException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
