<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mr. Wolf</title>
</head>
<body>
<form action="ForgetPasswordServ" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    
    <input type="submit" value="Send OTP">
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