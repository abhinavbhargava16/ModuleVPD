<%@page import="com.DAO.StatisticsDAO"%>
<%@page import="com.POJO.EmployeePOJO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.DAO.CampaignDAO"%>
<%@page import="com.POJO.CampaignPOJO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
	border-spacing: 65px 15px;
}
</style>
<script type="text/javascript">
function back()
{
	window.history.back();
}
</script>
</head>
<body>
<h1 align="center">Monitor Campaign Effectiveness</h1>
<%
	String x = (String)session.getAttribute("status");
if(!x.equals("True1")){
	request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
}
else{
	Connection conn = (Connection)request.getServletContext().getAttribute("connection");
	ArrayList<CampaignPOJO>myList = new ArrayList<CampaignPOJO>();
	CampaignDAO obj = new CampaignDAO();
	myList = obj.listCampaign(conn);
	Iterator<CampaignPOJO>i = myList.listIterator();

%>

<form action="MonitorServlet">
<table>
	<tr>
		<td>Campaign</td>
		<td>
			<select name="campaign"> <!-- campaign ID -->
				<option></option>
				<% while(i.hasNext()){
					CampaignPOJO temp = i.next(); 
					%>
				<option value=<%= temp.getCampaignID() %>><%= temp.getCampaignTitle() %></option>
				<%
				}
				%>
			</select>
		</td>
		<td><input type="submit" value="Search"></td>
	</tr>
</table>
</form>
<%
if(request.getAttribute("tot")!=null){ //tot is countAll + countUnassigned total count
	%>
<table>
	<tr>
		<td>Total prospects</td>
		<td><%=request.getAttribute("tot") %></td>
	</tr>
	<tr>
		<td>Unassigned prospects</td>
		<td><%=request.getAttribute("un")%></td> <!-- un is only unassigned prospects count -->
	</tr>
</table>
<%
}
%>


<table>
	<tr>
		<th>Sales Agent</th>
		<th>Assigned Prospects</th>
		<th>Follow-up in progress</th>
		<th>Not interested</th>
		<th>Committed</th>
	</tr>
	
	<%
	if(request.getAttribute("emList")!=null){ //emList is the arraylist which consists of all salespersons
		ArrayList<EmployeePOJO>em = (ArrayList<EmployeePOJO>)request.getAttribute("emList");
		Iterator<EmployeePOJO>j = em.listIterator(); //emlist is passed onto em.
		String campid = (String)request.getAttribute("campid"); //campaignId
		while(j.hasNext()){
			EmployeePOJO e = j.next();
			int empid = e.getEmployee_id(); //returns employee id
			
			%>
			<tr>
			<td><%= e.getName()%></td>
			<td><%=StatisticsDAO.getProspect(conn, e.getEmployee_id(), campid) %></td>
			<td><%=StatisticsDAO.getFollowUps(conn, e.getEmployee_id(), campid) %></td>
			<td><%=StatisticsDAO.getNotInterested(conn, e.getEmployee_id(), campid) %></td>
			<td><%=StatisticsDAO.getCommitted(conn, e.getEmployee_id(), campid) %></td>
			</tr>
	<%	
	}
	}
	%>
</table>
<p align="center"><input type="button" name="" value="Back" onclick="return back()"></p>
<%

}
%>
</body>
</html>