<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mr. Wolf</title>
</head>
<body>
    <form action="LoginServ" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
	<a href="SignUpPageJSP.jsp"><input type="submit" value="SignUp"></a>
	<a href="ForgetPasswordPageJSP.jsp">Forgot password?</a>
    <%-- Display error message if login fails --%>
    <%
        String error = request.getParameter("error");
        if (error != null && error.equals("InvalidCredentials")) {
            out.println("<p style='color:red;'>Invalid username or password. Please try again.</p>");
        }
    %>
</body>
</html>
