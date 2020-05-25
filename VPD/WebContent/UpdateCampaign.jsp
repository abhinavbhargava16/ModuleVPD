<%@page import="com.DAO.FindCampaignDAO, java.sql.Connection, com.POJO.CampaignPOJO"%>
<%-- <%@page import="com.POJOclass.Campaign"%>
<%@page import="java.sql.Connection;"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Campaign</title>
<style type="text/css">

.astreik::before {
  content: "*";
  color: red;
  float: left;
}

.boldd{
font-weight:bold
}

</style>
</head>
<body>
<%String id = request.getParameter("id");
Connection conn = (Connection)request.getServletContext().getAttribute("connection"); 
CampaignPOJO obj = new FindCampaignDAO().findCampaign(conn, id);
if(obj == null){
	//redirect to error page
}
%>
<h1>Update Campaign</h1>
<form action="UpdateServlet">
<table width="80%" class="boldd">

<tr>
<td class="astreik">Campaign Title  :</td>
<td colspan="2"><%=obj.getCampaignTitle()%></td>
</tr>

<tr>
<td class="astreik">Campaign Description :</td>
<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getCampaignDescription() %></td>
</tr>
<tr>
<td colspan="3"><u>Campaign Criteria:</u></td>
</tr>

<tr>
<td>Average Balance >:</td>
<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getAverageBalance() %></td>
</tr>

<tr>
<td>Age of Relationship >:</td>
<td colspan="2"><%=obj.getAgeOfRelationship() %></td>
</tr>

<tr>
<td>Profession  :</td>
<td colspan="2"><%=obj.getProfession() %></td>
</tr>

<tr>
<td class="astreik">Valid From :</td>
<td><input type="text" required name="valid_from" id="from"> eg:DD/MM/YYYY</td>
</tr>

<tr>
<td class="astreik">Valid to  :</td>
<td><input type="text" required name="valid_to" id="to"></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Submit">
<input type="reset" value="Reset">
<input type="button" value="Back" onclick="history.back()"></td>
</tr>

</table>
</form>
</body>
</html>