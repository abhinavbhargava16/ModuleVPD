package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InsertCampaignDAO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			ServletContext context = request.getServletContext();
			Connection conn = (Connection) context.getAttribute("connection");
			String id = request.getParameter("id");
			Date from = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_from"));
			Date to = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_to"));
			
			InsertCampaignDAO icd = new InsertCampaignDAO();
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
