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
		
		System.out.println("Inside assigned Prospective Servlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
		
		Connection conn = (Connection) request.getServletContext().getAttribute("connection");
		System.out.println("Inside try block of assigned Prospective Servlet");
		String id = request.getParameter("active"); //gets employee id to active
		ArrayList<ProspectivePOJO>prospectList = new ProspectDAO().selectProspect(conn, id); //returning details of customer and status
		
		if(prospectList!=null) {
			request.setAttribute("proList",prospectList); //setting the prospect list inside prolist
			
			System.out.println("Just before including reassign jsp");
			
			request.getRequestDispatcher("Reassign_Prospects.jsp").forward(request, response);
		}
		}catch(SQLException e) {
			e.printStackTrace();
			out.println("WE ARE HAVING TROUBLE FETCHING DATA!");
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			request.getRequestDispatcher("Reassign_Prospects.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
