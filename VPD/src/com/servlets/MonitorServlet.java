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

import com.DAO.CampaignDAO;
import com.DAO.EmployeeDAO;
import com.DAO.ProspectDAO;
import com.POJO.CampaignPOJO;
import com.POJO.EmployeePOJO;
import com.POJO.ProspectivePOJO;


@WebServlet("/MonitorServlet")
public class MonitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			
			Connection conn = (Connection) request.getServletContext().getAttribute("connection");
			
			String id = request.getParameter("campaign");
			request.setAttribute("campid", id);
			CampaignPOJO camp = new CampaignDAO().findCampaign(conn, id);
			int countAll = new ProspectDAO().countAllProspective(conn, camp);
			ArrayList<ProspectivePOJO>prospectList = new ProspectDAO().listUnassignedProspective(conn, camp);
			int countUnassigned=0;
			if(prospectList!=null) {
				countUnassigned = prospectList.size();
			}
			
			ArrayList<EmployeePOJO>emList = new EmployeeDAO().listSalespersonCampaign(conn, id);
			if(emList!=null) {
				request.setAttribute("emList", emList);
			}
			request.setAttribute("tot", countAll+countUnassigned);
			request.setAttribute("un", countUnassigned);
			request.getRequestDispatcher("Monitor_Campaign.jsp").forward(request, response);
			}
			catch(SQLException e) {
				out.println("WE ARE HAVING TROUBLE FETCHING DATA!");
			}
			catch(NullPointerException e) {
				request.getRequestDispatcher("Monitor_Campaign.jsp").forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
