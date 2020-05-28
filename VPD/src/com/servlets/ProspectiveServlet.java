package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
			System.out.println("Inside Prospect Servlet");
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Connection conn = (Connection) request.getServletContext().getAttribute("connection");
			
			String id = request.getParameter("campaign"); //campaign_id from campaignPOJO
			CampaignPOJO poj = new CampaignDAO().findCampaign(conn, id);
			ArrayList<ProspectivePOJO> prospectiveList = new ProspectDAO().listUnassignedProspective(conn, poj);
			
			if(prospectiveList!=null)
			{
				System.out.println("Inside Prospect List");
//				ListIterator<ProspectivePOJO> it = prospectiveList.listIterator();
//				while(it.hasNext())
//				{	
//					System.out.println(it);
//					it.next();
//				}
				request.setAttribute("proList", prospectiveList); //listofprospects
				request.setAttribute("campaignSelected", id); //campaign_id from POJO
				request.getRequestDispatcher("AssignProspects.jsp").forward(request, response);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			request.getRequestDispatcher("AssignProspects.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
