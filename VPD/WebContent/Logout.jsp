<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
session.setAttribute("status", "False");

out.println("You've Successfully Logged out");
%>
<a href="LoginPage.jsp">Click here to login</a>

</body>
</html>