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
import com.POJO.ProspectivePOJO;


@WebServlet("/AssignServlet")
public class AssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AssignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Inside assign servlet");
		try {
		
		String name[] = request.getParameterValues("prospectNames");
		String salesperson = request.getParameter("salesperson");
		String campaign = (String) request.getParameter("hid");
		ProspectDAO obj = new ProspectDAO();
		Connection conn = (Connection) request.getServletContext().getAttribute("connection");
		
		for(String i:name) {
			ProspectivePOJO p = new ProspectivePOJO();
			p.setCustomerID(Integer.parseInt(i));
			p.setCampaginID(campaign);
			p.setHandlerId(Integer.parseInt(salesperson));
			obj.insertProspective(conn, p);
			
		}
		out.print("SYSTEM:Salesperson with Employee ID-"+salesperson+" has been assign "+name.length+" prospect(s) for campaign id :"+campaign);
		request.getRequestDispatcher("AssignProspects.jsp").include(request, response);
		}catch(SQLException e) {
			out.println("SQL Exception");
			e.printStackTrace();
			
		}
		catch (NullPointerException e) {
			out.println("SYSTEM:CAN'T PROCESS EMPTY REQUESTS");
			request.getRequestDispatcher("AssignProspects.jsp").include(request, response);
			
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
