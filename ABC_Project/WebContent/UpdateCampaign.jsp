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
<h1>Update Campaign</h1>
<form>
<table width="80%" class="boldd">

<tr>
<td class="astreik">Campaign Title  :</td>
<td>xxxxxxxxxxxx</td>
</tr>

<tr>
<td class="astreik">Campaign Description :</td>
<td>xxxxxxxxxxxx</td>
</tr>

<tr></tr>
<tr>
<td><u>Campaign Criteria:</u></td>
</tr>

<tr>
<td>Average Balance >:</td>
<td>xxxxxxxxxxxx</td>
</tr>

<tr>
<td>Age of Relationship >:</td>
<td>xxxxxxxxxxxx</td>
</tr>

<tr>
<td>Profession  :</td>
<td>xxxxxxxxxxxx</td>
</tr>

<tr>
<td class="astreik">Valid From :</td>
<td><input type="date" required size="45" required> eg:DD/MM/YYYY</td>
</tr>

<tr>
<td class="astreik">Valid to  :</td>
<td><input type="date"></td>
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