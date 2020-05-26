<%@page import="java.sql.*, com.DBConnection.DBConnection, com.DAO.CampaignDAO, java.util.ArrayList, com.POJO.CampaignPOJO, java.util.ListIterator,
com.POJO.ProspectivePOJO, com.DAO.ProspectDAO, com.DAO.EmployeeDAO, com.POJO.EmployeePOJO;"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Prospects</title>
<script type="text/javascript">
function back()
{
	window.history.back();
}
</script>
</head>
<body>

<% String str = (String)session.getAttribute("status");
if(!str.equals("True1"))
{
	request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
}
else
{
	Connection conn = (Connection)request.getServletContext().getAttribute("connection");
	ArrayList <CampaignPOJO> myList = new ArrayList<CampaignPOJO>();
	CampaignDAO obj = new CampaignDAO();
	myList = obj.listCampaign(conn);
	ListIterator <CampaignPOJO> i = myList.listIterator();
%>

<h1>Assign Prospects to Sales Agents</h1>
<form action="ProspectiveServlet">
<table width="80%">

<tr>
<td>Campaign</td>
<td> 
<select name="campaign">
  <option>Select</option>
  <% while(i.hasNext()) 
  {
	  CampaignPOJO temp = i.next();
  %>
  <option value=<%=temp.getCampaignID() %>><%=temp.getCampaignTitle() %></option>
	<%
	} 
	%>
</select>
</td>

<td><button type="submit" value="Search">Search</button></td>
</tr>
</table>
</form>
<form action="AssignServlet">
<table>
	<tr>
		<th>Check</th>
		<th>Campaign Name</th>
		<th>Customer Name</th>
		<th>Phone Number</th>
	</tr>
	<%if(request.getAttribute("proList")!=null){ 
		String id = (String)request.getAttribute("campaignSelected");
	%>	
	<tr><td><input type="hidden" name="hid" value=<%=id %>></td></tr>
	<%
	ArrayList<ProspectivePOJO> proList = (ArrayList<ProspectivePOJO>)request.getAttribute("proList");
		ListIterator <ProspectivePOJO> j = proList.listIterator();
		while(i.hasNext())
		{
			ProspectivePOJO temp = j.next();
			String t = Integer.toString(temp.getCampaginID());
			CampaignPOJO proCamp = obj.findCampaign(conn, t);
	%>
	<tr>
	<td><input type="checkbox" id="check"  name="prospectnames" value =<%=temp.getCustomerID() %>></td>
		<td><%= proCamp.getCampaignTitle()%></td>
		<td><%=temp.getCustomerName()%></td>
		<td><%=temp.getPhoneNumber() %></td>
	</tr>
	<%
		}
	}%>	
</table>
<table>
<tr>
	<td>Employee's Name</td>
	<td>
	<%	ArrayList<EmployeePOJO> empList = new EmployeeDAO().listAllSalesperson(conn);
		ListIterator <EmployeePOJO> k = empList.listIterator();
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
	<td><input type="submit" value="Assign"></td>
	<td><input type="button" name="" value="Cancel" onclick="return back()"></td>
	</tr>
	
</table>

</form>
<%} %>
</body>
</html>