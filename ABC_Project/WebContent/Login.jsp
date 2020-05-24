<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
        span{
            color:crimson;
        }
</style>
<script>
function refesh()
{
	document.getElementById("name").focus();
	document.getElementById("name").reset();
    document.getElementById("password").reset();
}
function validate()
        {
             document.getElementById("name").focus();
            var name = document.getElementById("name").value;
            var password = document.getElementById("password").value;
            
            if(name==""||name==null)
                {
                 document.getElementById("s_name").innerHTML = "name must not be empty" ;
                    document.getElementById("name").focus();
                    return false;
                }
            else{
                document.getElementById("s_name").innerHTML="";
            }
            if(password==""|| password==null)
            {                
                document.getElementById("s_password").innerHTML="password should not be empty";
                document.getElementById("password").focus();
                return false;
            }
            else if(password.length<5)
            {                
                document.getElementById("s_password").innerHTML="password should be 5 digits";
                document.getElementById("password").focus();
                return false;
            }
           
        else{
            document.getElementById("s_password").innerHTML="";
        }
            return true;
        }
</script>
</head>
<body>

<h1 align="center">Welcome to Value-Plus Deposits Mobilization System</h1>
<form action="Login_servlet" method = "post">
	<table align="center">
		<tr>
			<td><span>*</span>User Name:</td>
			<td colspan="2"><input  type="text" name="username" id="name"></td>
			<td><span id="s_name"></span></td>
		</tr>
		<tr>
			<td><span>*</span>Password :</td>
			<td colspan="2"><input  type="password" name="password" id="password"></td>
			<td><span id="s_password"></span></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" onclick="return validate()"></td>
			<td><input type="reset" value="Clear" onclick="return refesh()"></td>
			<td></td>
		</tr>
	</table>
</form>

</body>
</html>