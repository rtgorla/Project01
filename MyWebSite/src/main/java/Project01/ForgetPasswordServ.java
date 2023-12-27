package Project01;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

@WebServlet("/ForgetPasswordServ")
public class ForgetPasswordServ extends HttpServlet {
	protected static String email;
	protected static int OTP;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
    	String query = "select * from ravidatabase.userbase where email=?";
        email = request.getParameter("email");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url);
            PreparedStatement pst = con.prepareStatement(query); 
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //generate otp
            	OTP = Integer.parseInt(generateOTP());
                response.sendRedirect("OTPPageJSP.jsp?error=" + OTP);
                
            } else {
                response.sendRedirect("ForgetPasswordPageJSP.jsp?error=Invalid email.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ForgetPasswordPageJSP.jsp?error=Error: " + e.getMessage());
        }
    }
    private String generateOTP() {
        return String.format("%06d", new Random().nextInt(1000000));
    }
    
}
