package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ProspectDAO;




@WebServlet("/ReassignServlet")
public class ReassignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
		
		String name[] = request.getParameterValues("prospectNames"); //customer ids
		String salesperson = request.getParameter("salesperson"); //employee ids
		ProspectDAO obj = new ProspectDAO();
		Connection conn = (Connection) request.getServletContext().getAttribute("connection");
		
		for(String i:name) {
			
			obj.updateProspectiveAssign(conn, salesperson,i);
			
		}
		
		out.print("Salesperson with <b>Employee ID</b>-"+salesperson+" has been assigned "+name.length+" prospect(s)");
		request.getRequestDispatcher("Reassign_Prospects.jsp").include(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
			out.println("WE ARE HAVING TROUBLE FETCHING DATA!");
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			out.println("SYSTEM:CAN'T PROCESS EMPTY REQUESTS");
			request.getRequestDispatcher("Reassign_Prospects.jsp").include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
