<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Campaign</title>
<%@page import="java.sql.*, com.DBConnection.DBConnection, com.dao.InsertCampaignDAO, java.util.ArrayList, com.POJOclass.Campaign, java.util.Iterator;"%>
</head>
<body>
<% String x = (String)session.getAttribute("status");
	if(!x.equals("True1"))
	{
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
	else 
	{
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		ArrayList<Campaign> campaignList = new InsertCampaignDAO().listCampaign(conn);
%>
<h1 align="center">List of Campaigns</h1>
<table align= "center" cellpadding="2px" cellspacing="20px">

<tr>
<td>Campaign Title</td>
<td>Valid from</td>
<td>Valid to</td>
</tr>
<%
Iterator<Campaign>i = campaignList.listIterator();
while(i.hasNext()){
	Campaign temp = i.next();

%>
<tr>
		<td><a href="UpdateCampaign.jsp?id=<%= temp.getCampaignID() %>"><%=temp.getCampaignTitle() %></a></td>
		<td><%= temp.getValid_from() %></td>
		<td><%= temp.getValid_to() %></td>
		<%} %>
		<%
}
%>
<td><input type="button" value="Back" onclick="history.back()"></td>
<td></td>
</tr>
</table>
</body>
</html>