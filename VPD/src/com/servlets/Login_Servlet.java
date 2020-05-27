package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.POJO.EmployeePOJO;
import com.DAO.EmployeeDAO;

@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Inside Login Servlet");
		try
		{
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		EmployeeDAO obj = new EmployeeDAO();
		Connection conn = (Connection) context.getAttribute("connection");
		EmployeePOJO e = obj.checkUser(conn, username, password);
		if(e==null)
		{
			session.setAttribute("status","False");
			out.println("Invalid username/password");
			request.getRequestDispatcher("LoginPage.jsp").include(request, response);	
		}
		else if(e.getRole()==3) 
		{
			session.setAttribute("status", "True1");
			session.setAttribute("user", e);
			request.getRequestDispatcher("Campaign_Menu.jsp").forward(request, response);
		}
		else if(e.getRole()==2)
		{
			session.setAttribute("status", "True2");
			session.setAttribute("user", e);
			request.getRequestDispatcher("AssignProspects.jsp").forward(request, response);
		}
		else
		{
			session.setAttribute("status", "False");
			out.println("Login User must be either a Manager or Sales Agent");
			request.getRequestDispatcher("LoginPage.jsp").include(request, response);
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("WE ARE HAVING TROUBLE FETCHING DATA!");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
