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
import com.DAO.ProspectDAO;
import com.POJO.CampaignPOJO;
import com.POJO.ProspectivePOJO;


@WebServlet("/ProspectiveServlet")
public class ProspectiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Connection conn = (Connection) request.getServletContext().getAttribute("connection");
			
			String id = request.getParameter("campaign");
			CampaignPOJO poj = new CampaignDAO().findCampaign(conn, id);
			ArrayList<ProspectivePOJO> prospectiveList = new ArrayList<ProspectivePOJO>();
			
			if(prospectiveList!=null)
			{
				request.setAttribute("proList", prospectiveList);
				request.setAttribute("campaignSelected", id);
				request.getRequestDispatcher("AssignProspects.jsp").forward(request, response);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			request.getRequestDispatcher("AssignProspects.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
