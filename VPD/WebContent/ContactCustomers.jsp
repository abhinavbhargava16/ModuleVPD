<%@page import="com.DAO.CampaignDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.DAO.ProspectDAO"%>
<%@page import="com.POJO.ProspectivePOJO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.POJO.EmployeePOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
	border-spacing: 50px;
}
</style>
</head>
<body>

<%
EmployeePOJO e = (EmployeePOJO)session.getAttribute("user");
Connection conn = (Connection)request.getServletContext().getAttribute("connection");
ArrayList<ProspectivePOJO>proList = new ProspectDAO().selectProspect(conn, Integer.toString(e.getEmployee_id()));
Iterator<ProspectivePOJO>i = proList.listIterator();
%>
<h1 align="center">List of Prospective Customers</h1>
<p align="right">Hi <%=e.getEmployee_id() %> </p>
<p align="right"><a href="Logout.jsp">Logout</a></p>

	<table>
		<tr>
			<th>Campaign title</th>
			<th>Prospect Name</th>
			<th>Contact Number</th>
			<th>Status</th>
		</tr>
		<%
		while(i.hasNext()){
			ProspectivePOJO p = i.next();
			%>
		<tr>
<td><a href="CampaignFile.jsp?id=<%= p.getCampaginID() %>"><%= new CampaignDAO().findCampaign(conn, p.getCampaginID()).getCampaignTitle() %></a></td>			
<td><a href="Update_Prospect.jsp?custId=<%=p.getCustomerID()%>"><%=p.getCustomerName() %></a></td>
			<td><%=p.getPhoneNumber() %></td>
			<td><%= p.getStatus() %></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>