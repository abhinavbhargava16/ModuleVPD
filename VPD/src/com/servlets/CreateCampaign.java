package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.POJO.CampaignPOJO;
import com.POJO.EmployeePOJO;
import com.DAO.CampaignDAO;
import com.DAO.EmployeeDAO;


@WebServlet("/CreateCampaign")
public class CreateCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CampaignDAO icd = new CampaignDAO();
		try
		{
			System.out.println("inside campaign");
			CampaignPOJO obj = new CampaignPOJO();
			obj.setCampaignTitle(request.getParameter("campaignTitle"));
			obj.setCampaignDescription(request.getParameter("campaignDescription"));
			obj.setValid_from(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_from")));
			obj.setValid_to(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("valid_to")));
			obj.setAgeOfRelationship(Integer.parseInt(request.getParameter("ageOfRelationship")));
			obj.setAverageBalance(Double.parseDouble(request.getParameter("averageBalance")));
			obj.setProfession(request.getParameter("profession"));
			HttpSession session = request.getSession();
			ServletContext context = request.getServletContext();
			EmployeePOJO emp_id = new EmployeePOJO();
			emp_id = (EmployeePOJO) session.getAttribute("user");
			Connection conn = (Connection) context.getAttribute("connection");
			icd.insertCampaign(conn,obj,emp_id);
			out.println("New Campaign Created");
			request.getRequestDispatcher("Campaign_Menu.jsp").include(request, response);

		}
		catch (ParseException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


