package com.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.DBConnection.DBConnection;


@WebListener
public class DBListener implements ServletContextListener {

  

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext context = sce.getServletContext();
    	Connection conn = (Connection)context.getAttribute("connection");
    	try {
			conn.close();
		} catch (SQLException e) {
			// replace this with a redirect to the error page
			e.printStackTrace();
		}
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext context = sce.getServletContext();
    	try {
    		
			Connection conn = DBConnection.getConnection();
			context.setAttribute("connection", conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			// replace this with a redirect to the error page
			e.printStackTrace();
			
		}
    }
	