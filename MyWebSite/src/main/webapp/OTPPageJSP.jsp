<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mr. Wolf</title>
</head>
<body>
<h1>otp</h1>
<form action="OTPServ" method="post">
    <label for="OTP">OTP:</label>
    <input type="password" id="otp" name="otp" required>
    
    <input type="submit" value="Submit">
</form>
<%
    String error = request.getParameter("error");
    if (error != null && !error.isEmpty()) {
        out.println("<p>" + error + "</p>");
    }
%>
</body>
</html>