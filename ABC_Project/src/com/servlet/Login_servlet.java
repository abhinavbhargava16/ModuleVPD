package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.POJOclass.Employee;
import com.dao.Employee_dao;

@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		
		RequestDispatcher rd;
		
		String user="",pass="";
		int id=0;
		Employee_dao ob = new Employee_dao();
		Employee tt;
		try {
			tt = ob.checkUser(username);
			user = tt.getUsername();
			pass = tt.getPassword();
			id=tt.getUserid();
		} 
		
		catch (ClassNotFoundException |SQLException  e) 
		{
			e.printStackTrace();
		} 	   
		
		out.println(user + pass + id);
		
		if(username.equals(user) && password.equals(pass))
		{
			if(id==1)
			{
				rd=request.getRequestDispatcher("/Campaign.html");
			    rd.forward(request, response);
			}
			else if(id==2)
			{
				rd=request.getRequestDispatcher("ContactCustomers.jsp");
			    rd.forward(request, response);
			}
		}
		else
		{
			out.println("<font color=red>Invalid Username/Password</font>");
			rd = request.getRequestDispatcher("/Login.html");
			rd.include(request, response);

		}
	}

}
