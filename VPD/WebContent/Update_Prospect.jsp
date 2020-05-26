<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DAO.ProspectDAO" %>
<%@page import="com.DAO.CampaignDAO" %>
<%@page import="com.DAO.StatusDAO" %>
<%@page import="com.POJO.CampaignPOJO" %>
<%@page import="com.POJO.ProspectivePOJO" %>
<%@page import="com.POJO.StatusPOJO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	span{
            color:crimson;
        }
    table{
    	border-spacing: 50px 15px;
    }    
</style>
<script type="text/javascript">
function back()
{
	window.history.back();
}
function refresh()
{
	 var dropDown = document.getElementById("status");  
     dropDown.selectedIndex = 0;
}
</script>
</head>
<body>

<%String id = request.getParameter("custId");
Connection conn = (Connection)request.getServletContext().getAttribute("connection");
ProspectivePOJO p = new ProspectDAO().getDetails(conn, id);
CampaignPOJO obj = new CampaignDAO().findCampaign(conn, Integer.toString(p.getCampaginID()));
ArrayList<StatusPOJO>custList = new StatusDAO().custStatus(conn, Integer.toString(p.getCustomerID()));
Iterator<StatusPOJO>i = custList.listIterator();
%>
<form action="StatusUpdateController">
<h1 align="center">Update Prospect</h1>
	<table>
		<tr>
			<td><span>*</span>Campaign Title  </td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getCampaignTitle() %></td>
		</tr>
		<tr>
			<td><span>*</span>Campaign Description </td>
			<td colspan="3" style="padding:30px 0px 0px 30px;"><%=obj.getCampaignDescription() %></textarea></td>
		</tr>
		<tr>
			<td>Customer name  </td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=p.getCustomerName() %></td>
			
		</tr>
		<tr>
			<td>Customer number </td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=p.getCustomerID() %></td>
			
		</tr>
		<tr>
			<td>Average Balance </td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=p.getBalance() %></td>
			
		</tr>
		<tr>
			<td>Age of Relationship </td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=p.getAgeOfRelationship() %></td>
			
		</tr>
		<tr>
			<td>Profession  </td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=p.getOccupation() %></td>
			
		</tr>
		<tr>
			<td><span>*</span>Status</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;">
				<select id="status" name="status">
					<option></option>
					<option>Follow-up in progress</option>
					<option>Not interested</option>
					<option>Committed</option>
				</select>
			</td>
		</tr>
</table>
<br>
<table>
	<tr>
		<th>Status History</th>
	</tr>
	<tr>
		<th>Date</th>
		<th>Status</th>
		<th>Remarks</th>
	</tr>
	<%
	while(i.hasNext()){
		StatusPOJO x = i.next();
	%>
	<tr>
		<td><%=x.getDatestamp() %></td>
		<td><%=x.getStatus() %></td>
		
	</tr>
	<%} %>
</table>
<table align="center">
		<tr>
			<td><input type="hidden" name="customerID" value=<%=p.getCustomerID() %>></td>
			<td><input type="submit" name="" value="Sumbit" onclick="return validate()"></td>
			<td><input type="button" name="" value="Refresh" onclick="return refresh()"></td>
			<td><input type="button" name="" value="Back" onclick="return back()"></td>
		</tr>
</table>
</form>
</body>
</html>