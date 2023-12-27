package Project01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServ")
public class SignupServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String dateofbirth = request.getParameter("dateofbirth");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");

        try {
        	if (!password.equals(confirm_password)) {
                response.sendRedirect("signUpPageJSP.jsp?error=Passwords do not match. Please try again.");
                return;
            }
            String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
            String sql = "INSERT INTO ravidatabase.userbase (firstname, lastname, username, email, dateofbirth, password) VALUES (?, ?, ?, ?, ?, ?)";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, email);
            statement.setString(5, dateofbirth);
            statement.setString(6, password);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("Login.jsp");
            } else {
                response.sendRedirect("SignUpPageJSP.jsp?error=Signup failed. Please try again.");
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            response.sendRedirect("SignUpPageJSP.jsp?error=Error: " + e.getMessage());
        }
    }
}
