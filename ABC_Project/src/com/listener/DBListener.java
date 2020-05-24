package com.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.DBConnection.DBConnection;

/**
 * Application Lifecycle Listener implementation class DBListener
 *
 */
@WebListener
public class DBListener implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	ServletContext context = arg0.getServletContext();
    	Connection conn = (Connection)context.getAttribute("connection");
    	try {
			conn.close();
		} catch (SQLException e) {
			// replace this with a redirect to the error page
			e.printStackTrace();
		}
    }
	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext context = arg0.getServletContext();
    	try {
    		
			Connection conn = DBConnection.getConnection();
			context.setAttribute("connection", conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			// replace this with a redirect to the error page
			e.printStackTrace();
			
		}
    }
}