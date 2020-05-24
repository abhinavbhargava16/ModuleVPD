<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create A Campaign</title>
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
<script type="text/javascript">
function validate()
{
	 	document.getElementById("name").focus();
	    var avg = document.getElementById("avg").value;
	    var age = document.getElementById("age").value;
	    var profession = document.getElementById("profession").value;
	    var from = document.getElementById("date1").value;
	    var to = document.getElementById("date2").value;
	    var Date1 = new Date(from);
	    var Date2 = new Date(to);
	   
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
<meta charset="ISO-8859-1">
<title>Update Campaign</title>
</head>
<body>
<form action="InsertCampaign" method="post">
<table width="80%" class="boldd" align="center">
<h1 align="center">Create a new Campaign </h1>

<tr>
<td class="astreik">Campaign Title  :</td>
<td><input type="text"  required name="campaignTitle" id="name"></td>
</tr>

<tr>
<td class="astreik">Campaign Description :</td>
<td><textarea cols='45' rows='6' required name="campaignDescription"></textarea></td>
</tr>

<tr></tr>
<tr>
<td><u>Campaign Criteria:</u></td>
</tr>

<tr>
<td>Average Balance >:</td>
<td><input type="number" name="averageBalance"></td>

</tr>

<tr>
<td>Age of Relationship >:</td>
<td><input type="text" name="ageOfRelationship" ></td>
</tr>

<tr>
<td>Profession  :</td>
<td><input type="text" required size="45" name="profession"></td>
</tr>

<tr>
<td class="astreik">Valid From :</td>
<td><input type="date"  required name="valid_from" id="date1"> eg:DD/MM/YYYY</td>
<td><span id="s_from"></span></td>
</tr>

<tr>
<td class="astreik">Valid to  :</td>
<td><input type="date" id="date2" name="valid_to"></td>
<td><span id="s_to"></span></td>
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