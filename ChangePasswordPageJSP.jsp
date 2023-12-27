<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mr. Wolf</title>
</head>
<body>
	<form action="ChangePasswordServ" method="post">
    <label for="password">Enter new password:</label>
    <input type="password" id="password" name="password" required><br>
    <label for="cpassword">Conform password:</label>
    <input type="password" id="cpassword" name="cpassword" required><br>
    
    <input type="submit" value="Change Password">
</form>

<p>Remember your password? <a href="Login.jsp">Login</a></p>
<%
    String error = request.getParameter("error");
    if (error != null && !error.isEmpty()) {
        out.println("<p>" + error + "</p>");
    }
%>
</body>
</html>