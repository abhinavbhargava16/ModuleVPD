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

import com.DAO.StatusDAO;

/**
 * Servlet implementation class StatusUpdateController
 */
@WebServlet("/StatusUpdateController")
public class StatusUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerID = request.getParameter("customerID");
		String status = request.getParameter("status");
		PrintWriter out = response.getWriter();
		Connection conn = (Connection) request.getServletContext().getAttribute("connection");
		out.println(customerID+"-Status updated-"+status);
		try {
			new StatusDAO().updateStatus(conn, customerID, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}