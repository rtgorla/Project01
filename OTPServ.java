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

@WebServlet("/OTPServ")
public class OTPServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        String otp = request.getParameter("otp");
            if (otp.equals(ForgetPasswordServ.OTP + "")) {
                response.sendRedirect("ChangePasswordPageJSP.jsp?");
                
            } else {
                response.sendRedirect("OTPPageJSP.jsp?error=Invalid OTP.");
            }
    }
}
