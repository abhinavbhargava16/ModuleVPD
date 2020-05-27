<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.POJO.*"%>
<%@page import="com.DAO.*"%>

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
<script type="text/javascript">
function validate()
{
	window.history.back();
}
</script>
</head>
<body>

<%
String x = (String)session.getAttribute("status");

if(!x.equals("True1")){
	
	request.getRequestDispatcher("Login.jsp").forward(request, response);
}
else{
	Connection conn = (Connection)request.getServletContext().getAttribute("connection"); 
	ArrayList<CampaignPOJO>campaignList = new CampaignDAO().listCampaign(conn);
	
%>
<h1 align="center">List of campaigns</h1>
<table align="center">
	<tr>
		<th>Campaign Title</th>
		<th>Valid from</th>
		<th>Valid to</th>
	</tr>
	
<% Iterator<CampaignPOJO>i = campaignList.listIterator();
	while(i.hasNext()){
		CampaignPOJO temp = i.next();
	
%>
	<tr>
		<td><a href="UpdateCampaign.jsp?id=<%= temp.getCampaignID() %>"><%=temp.getCampaignTitle() %></a></td> <!-- id=campaignid -->
		<td><%=temp.getValid_from() %></td>
		<td><%=temp.getValid_to() %></td>
	</tr>
	
	<%} %>
</table>
<%
}
%>
<P align="center"><input type="button" value="Back" onclick="return validate()"></P>


</body>
</html>