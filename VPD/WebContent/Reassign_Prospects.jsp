<%@page import="com.DAO.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.DAO.CampaignDAO, com.DAO.EmployeeDAO"%>  
<%@page import="com.POJO.CampaignPOJO, com.POJO.EmployeePOJO, com.POJO.ProspectivePOJO" %>
<%@page import="java.sql.Connection, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	span{
            color:crimson;
        }
    table{
    	border-spacing: 50px 15px;
    }    
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reassign Prospects</title>
</head>
<body>
<% 
String str = (String)session.getAttribute("status");
if(!str.equals("True1"))
{
	request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
}
else
{
	Connection conn = (Connection)request.getServletContext().getAttribute("connection");
	ArrayList<EmployeePOJO> assignList = new ArrayList<EmployeePOJO>(); 
	EmployeeDAO obj = new EmployeeDAO();
	assignList = obj.getAssignedSalesPerson(conn);
	Iterator<EmployeePOJO> i = assignList.listIterator();
%>	
<h1>Re-assign Prospects to Sales Agents</h1>
<form action="AssignedProspectiveServlet">
<table width="80%">

<tr>
<td>Sales agent</td>
<td>
	<select name="active">
	<option value="Select"></option>
	<%
		while(i.hasNext()){
		EmployeePOJO temp = i.next();
		%>
		<option value=<%=temp.getEmployee_id() %>><%=temp.getName() %></option>
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
	<%if(request.getAttribute("proList")!=null){
		ArrayList<ProspectivePOJO> proList = (ArrayList<ProspectivePOJO>)request.getAttribute("proList");
		Iterator<ProspectivePOJO> j = proList.listIterator();
		CampaignDAO obj2 =  new CampaignDAO();
		
		while(j.hasNext())
		{
			ProspectivePOJO temp = j.next();
			String t = Integer.toString(temp.getCampaginID());
			CampaignPOJO proCamp = obj2.findCampaign(conn, t);
		
	%>
	<tr>
	<td><input type="checkbox" id="check" name="prospectNames" value=<%=temp.getCampaginID()%>></td>
	<td><%=proCamp.getCampaignTitle() %></td>
	<td><%=temp.getCustomerName() %></td>
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
<%ArrayList<EmployeePOJO> empList = new EmployeeDAO().listAllSalesperson(conn);
	Iterator<EmployeePOJO> k = empList.listIterator(); 
%>
<select name="salesperson">
<%while(k.hasNext()) 
{
	EmployeePOJO sale = k.next();
%>

<option value=<%=sale.getEmployee_id() %>><%=sale.getName() %></option>
<%
}
%>
</select>
</td>
<td><input type="submit" value="Re-Assign">Re-assign</td>
<td><input type="reset" value="Cancel" onclick="history.back()">Cancel</td>
</tr>
</table>
</form>
<% 
	} 
%>


</body>
</html>