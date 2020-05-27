package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.POJO.ProspectivePOJO;
import com.DAO.ProspectDAO;


@WebServlet("/AssignedProspectiveServlet")
public class AssignedProspectiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AssignedProspectiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
		
		Connection conn = (Connection) request.getServletContext().getAttribute("connection");
		
		String id = request.getParameter("active");
		ArrayList<ProspectivePOJO>prospectList = new ProspectDAO().selectProspect(conn, id);
		
		if(prospectList!=null) {
			request.setAttribute("proList", prospectList);
			
			request.getRequestDispatcher("Re-assign_Prospects.jsp").forward(request, response);
		}
		}catch(SQLException e) {
			out.println("WE ARE HAVING TROUBLE FETCHING DATA!");
		}
		catch(NullPointerException e) {
			request.getRequestDispatcher("Re-assign_Prospects.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
