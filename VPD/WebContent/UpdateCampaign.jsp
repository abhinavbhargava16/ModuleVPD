<%@page import="com.DAO.*"%>
<%@page import="com.POJO.*"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Campaign</title>
<style type="text/css">
	span{
            color:crimson;
        }
</style>
<script type="text/javascript">
function back()
{
	window.history.back();
}
function validate()
{
	 document.getElementById("from").focus();
    var from = document.getElementById("from").value;
    var to = document.getElementById("to").value;
    var Date1 = new Date(from);
    var Date2 = new Date(to);
    if(from==""||from==null)
    {
    	document.getElementById("s_from").innerHTML="Valid From should not be empty";
        document.getElementById("from").focus();
    	return false;
    }
    else
    {
        document.getElementById("s_from").innerHTML="";
    }
    if(to==""||to==null)
    {
    	document.getElementById("s_to").innerHTML="Valid To should not be empty";
        document.getElementById("to").focus();
    	return false;
    }
    else if(Date1>Date2)
    	{
    	document.getElementById("s_to").innerHTML="";
    	document.getElementById("s_from").innerHTML="Valid From should not be later than the Valid to date";
        document.getElementById("from").focus();
    	return false;
    	}
    else
    {
        document.getElementById("s_from").innerHTML="";
    }
    return true;
}

</script>
</head>
<body>
<%String id = request.getParameter("id");
Connection conn = (Connection)request.getServletContext().getAttribute("connection"); 
CampaignPOJO obj = new CampaignDAO().findCampaign(conn, id);
if(obj == null){
	//redirect to error page
}
%>
<form action="UpdateServlet">
<h1 align="center">Update campaign</h1>
	<table>
		<tr>
			<td>Campaign Title   :</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getCampaignTitle() %></td>
			<td></td>
		</tr>
		<tr>
			<td>Campaign Description :</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getCampaignDescription() %></td>
		</tr>
		<tr>
			<td>Campaign Criteria</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td>Average Balance >:</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getAverageBalance() %></td>
			<td></td>
		</tr>
		<tr>
			<td>Age of Relationship >:</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getAgeOfRelationship() %></td>
			<td></td>
		</tr>
		<tr>
			<td>Profession   :</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><%=obj.getProfession() %></td>
			<td></td>
		</tr>
		<tr></tr>
		<tr>
			<td><span>*</span>Valid From   :</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><input type="text" name="valid_from" id="from"></td>
			<td>e.g.:DD/MM/YYYY<span id="s_from"></span></td>
		</tr>
		<tr>
			<td><span>*</span>Valid to    :</td>
			<td colspan="2" style="padding:0px 0px 0px 30px;"><input type="text" name="valid_to" id="to"></td>
			<td><span id="s_to"></span></td>
		</tr>
		<tr>
			<td><input type="hidden" name="id" value=<%=obj.getCampaignID()%>></td>
			
			<td><input type="submit" name="" value="Sumbit" onclick="return validate()"></td>
			<td><input type="reset" name="" value="Refresh"></td>
			<td><input type="button" name="" value="Back" onclick="return back()"></td>
		</tr>
	</table>
</form>
</body>
</html>