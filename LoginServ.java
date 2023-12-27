package Project01;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
    	String query = "select * from ravidatabase.userbase where username=? AND password=?";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url);
            PreparedStatement pst = con.prepareStatement(query); 
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                response.sendRedirect("HomePage.jsp");
            } else {
                // Login failed
                response.sendRedirect("Login.jsp?error=InvalidCredentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Login.jsp?error=Error: " + e.getMessage());
        }
    }
}
