<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mr. Wolf</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<form action="SignupServ" method="post">
    <label for="firstname">First Name:</label>
    <input type="text" id="firstname" name="firstname" required><br>

    <label for="lastname">Last Name:</label>
    <input type="text" id="lastname" name="lastname" required><br>

    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="dateofbirth">Date of Birth:</label>
    <input type="date" id="dateofbirth" name="dateofbirth" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="confirm_password">Confirm Password:</label>
    <input type="password" id="confirm_password" name="confirm_password" required><br>

    <input type="submit" value="SignUp">
</form>
	<p>Already have an account? <a href="login.jsp">Login</a></p>
<%
    String error = request.getParameter("error");
    if (error != null && !error.isEmpty()) {
        out.println("<p>" + error + "</p>");
    }
%>
<script>
function formatDate() {
    // Get the date input value
    var dateInput = document.getElementById("dateofbirth").value;

    // Convert the date string to a Date object
    var dateObject = new Date(dateInput);

    // Format the date as yyyy-mm-dd
    var formattedDate = dateObject.getFullYear() + '-' +
                        ('0' + (dateObject.getMonth() + 1)).slice(-2) + '-' +
                        ('0' + dateObject.getDate()).slice(-2);

    // Set the formatted date back to the input
    document.getElementById("dateofbirth").value = formattedDate;
}
</script>
</body>
</html>
