<%@page import="java.sql.SQLException"%>
<%@page import="com.POJO.EmployeePOJO"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@page import="com.POJO.ProspectivePOJO"%>
<%@page import="com.POJO.CampaignPOJO"%>
<%@page import="java.util.ListIterator"%>
<%@page import="com.DAO.CampaignDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Prospects</title>
<style type="text/css">
	table{
		border-spacing: 50px 15px;
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
<%	
	String x = (String)session.getAttribute("status");
if(!x.equals("True1")){
	request.getRequestDispatcher("Login.jsp").forward(request, response);
}
else{
	Connection conn = (Connection)request.getServletContext().getAttribute("connection");
	ArrayList<CampaignPOJO>myList = new ArrayList<CampaignPOJO>();
	CampaignDAO obj = new CampaignDAO();
	
	myList = obj.listCampaign(conn);
	ListIterator<CampaignPOJO>i = myList.listIterator();
	

%>

<h1 align="center">Assign prospects to Sales Agents</h1>
<form action="ProspectiveServlet">
<table>
	<tr>
		<td>Campaign</td>
		<td>
			<select name="campaign">
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

<form action="AssignServlet">

<table>
	<tr>
		<th>Check</th>
		<th>Campaign Name</th>
		<th>Customer name</th>
		<th>Phone Number</th>
	</tr>
	<%if(request.getAttribute("proList")!=null){
		String id = (String)request.getAttribute("campSelected");
		%>
		<tr><td><input type="hidden" name ="hid" value=<%=id %>></td></tr>
		<%
		ArrayList<ProspectivePOJO>proList = (ArrayList<ProspectivePOJO>)request.getAttribute("proList");
		ListIterator<ProspectivePOJO>j = proList.listIterator();
		
		while(j.hasNext()){
			ProspectivePOJO temp = j.next();
			CampaignPOJO proCamp = obj.findCampaign(conn, temp.getCampaginID());
			%>
	<tr>
		<td><input type="checkbox" id="check" name="prospectNames" value=<%=temp.getCustomerID() %>></td>
		<td><%= proCamp.getCampaignTitle()%></td>
		<td><%=temp.getCustomerName()%></td>
		<td><%=temp.getPhoneNumber() %></td>
		
		
	</tr>
	<%
		}
	}
		%>
	
</table>
<p id="s_check"></p>
<table>
	<tr>
		<td>Employee's name</td>
		<td>
		<%ArrayList<EmployeePOJO>empList = new EmployeeDAO().listAllSalesperson(conn);
		ListIterator<EmployeePOJO>k = empList.listIterator();
		
		%>
			<select name="salesperson">
			<%while(k.hasNext()){
				
				EmployeePOJO sale = k.next();
				%>
			
				
				<option value=<%=sale.getEmployee_id() %>><%=sale.getName() %></option>
				<%
				}
				%>
			</select>
		</td>
	
		<td><input type="submit" value="Assign"></td>
		<td><input type="button" name="" value="Cancel" onclick="return back()"></td>
	</tr>
</table>

</form>

<% 
}
%>
</body>
</html>