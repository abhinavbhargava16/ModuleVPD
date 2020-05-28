<%@page import="com.DAO.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.DAO.CampaignDAO, com.DAO.EmployeeDAO"%>  
<%@page import="com.POJO.CampaignPOJO, com.POJO.EmployeePOJO, com.POJO.ProspectivePOJO" %>
<%@page import="java.sql.Connection, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reassign Prospects</title>
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
	request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
}
else{
	Connection conn = (Connection)request.getServletContext().getAttribute("connection");
	ArrayList<EmployeePOJO>assignList = new ArrayList<EmployeePOJO>();
	EmployeeDAO obj = new EmployeeDAO();
	assignList = obj.getAssignedSalesPerson(conn); //returns epmloyee list in the prospect table
	Iterator<EmployeePOJO>i = assignList.listIterator();
%>
<h1 align="center">Re-assign prospects</h1>
<form action="AssignedProspectiveServlet">
<table>
	<tr>
		<td>Sales Agent</td>
		<td>
			<select name="active"> <!-- returns employee id -->
				<option></option>
				<%
				while(i.hasNext()){
					EmployeePOJO temp = i.next();
				
				%>
				<option value=<%=temp.getEmployee_id() %>><%= temp.getName() %></option>
				<%
				}
				%>
			</select>
		</td>
		<td><input type="submit" value="Search"></td>
	</tr>
</table>
</form>

<form action="ReassignServlet">
<table>
	<tr>
		<th>Check</th>
		<th>Campaign Name</th>
		<th>Customer name</th>
		<th>Phone Number</th>
	</tr>

	<%if(request.getAttribute("proList")!=null){ //gets the prospect list assigned to the employee id
		ArrayList<ProspectivePOJO>proList = (ArrayList<ProspectivePOJO>)request.getAttribute("proList"); //stores the list inside the array list
		Iterator<ProspectivePOJO>j = proList.listIterator();
		CampaignDAO obj2 = new CampaignDAO();
		
		while(j.hasNext()){
			ProspectivePOJO temp = j.next(); //returning customerid customer name and phone number and campaign id
			CampaignPOJO proCamp = obj2.findCampaign(conn, temp.getCampaginID()); //passes connection and campaign id
			%>
		<tr>
		<td><input type="checkbox" id="check" name="prospectNames" value=<%=temp.getCustomerID() %>></td>
		<td><%= proCamp.getCampaignTitle()%></td> <!-- returns campaign title with the help of campaign ID -->
		<td><%=temp.getCustomerName()%></td>
		<td><%=temp.getPhoneNumber() %></td>
		
		
	</tr>
	<%
		}
	}
		%>
	
</table>
<table>
	<tr>
		<td>Reassign to</td>
		<td>
		<%ArrayList<EmployeePOJO>empList = new EmployeeDAO().listAllSalesperson(conn);
		Iterator<EmployeePOJO>k = empList.listIterator();
		
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
		<td><input type="submit" value="Re-Assign"></td>
		<td><input type="button" name="" value="Cancel" onclick="return back()"></td>
	</tr>
</table>
</form>
<%
}
%>
</body>
</html>