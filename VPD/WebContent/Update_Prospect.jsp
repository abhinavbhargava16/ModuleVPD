<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Prospect</title>
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
<h1>Update Prospect</h1>

<form >
<table width="80%" class="boldd">

<tr>
<td >Campaign Title  :</td>
<td>xxxxx<td>
</tr>

<tr>
<td>Campaign Description :</td>
<td>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx<td>
</tr>


<tr>
<td>Customer Name:</td>
<td>xxxxx<td>
</tr>

<tr>
<td>Contact Number:</td>
<td>xxxxxxxxxx</td>
</tr>


<tr>
<td>Average Balance:</td>
<td>xxxxxxxxx</td>
</tr>

<tr>
<td>Age of Relationship:</td>
<td>xxxxx</td>
</tr>

<tr>
<td>Profession  :</td>
<td>xxxxxxxxxx</td>
</tr>

<tr>
<td class="astreik">Status</td>
<td> 
<select >
  <option>select</option>
  <option>Committed</option>
  <option>Not Interested</option>
</select>
</td>
</table>
</form>

<br>
<br>
<table cellpadding="2px" cellspacing="20px">

<tr>
<th>Status History</th>
</tr>

<tr>
<td>Date</td>
<td>Status</td>
<td>Remarks</td>
</tr>

<tr>
</tr>

<tr>
</tr>

<tr>
</tr>

<tr>
</tr>


<tr>
<td></td>
<td><input type="submit" value="Submit"></td>
<td><input type="reset" value="Refresh"></td>
<td><input type="button" value="Back" onclick="history.back()"></td>
</tr>
</table>


</body>
</html>