package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CampaignDAO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{	
			System.out.println("Inside Update Campaign");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			ServletContext context = request.getServletContext();
			Connection conn = (Connection) context.getAttribute("connection");
			String id = request.getParameter("id");
			Date from = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_from"));
			Date to =  new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_to"));
			
			CampaignDAO icd = new CampaignDAO();
			icd.updateCampaign(conn, id, from, to);
			out.println("Campaign Updated");
			request.getRequestDispatcher("Campaign_Menu.jsp").include(request, response);
		}
		catch (ParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
