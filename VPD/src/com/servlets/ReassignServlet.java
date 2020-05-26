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



/**
 * Servlet implementation class ReassignServlet
 */
@WebServlet("/ReassignServlet")
public class ReassignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReassignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		PrintWriter out = response.getWriter();
		String name[] = request.getParameterValues("prospectNames");
		String salesperson = request.getParameter("salesperson");
		ProspectDAO obj = new ProspectDAO();
		Connection conn = (Connection) request.getServletContext().getAttribute("connection");
		
		for(String i:name)
		{
			obj.updateProspectiveAssign(conn, Integer.parseInt(i), Integer.parseInt(salesperson));
			
		}
		out.println("Salesperson with employee ID- "+salesperson+" has been assign "+name.length+"prospects");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
