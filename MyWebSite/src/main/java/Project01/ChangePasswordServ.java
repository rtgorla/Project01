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

@WebServlet("/ChangePasswordServ")
public class ChangePasswordServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
        String selectQuery = "SELECT password FROM ravidatabase.userbase WHERE email = ?";
        String updateQuery = "UPDATE ravidatabase.userbase SET password = ? WHERE email = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url);
                 PreparedStatement pStat = con.prepareStatement(selectQuery);
                 PreparedStatement updatePstat = con.prepareStatement(updateQuery)) {

                pStat.setString(1, ForgetPasswordServ.email);
                ResultSet rs = pStat.executeQuery();

                if (rs.next()) {
                    String oPassword = rs.getString("password");
                    String nPassword = request.getParameter("password");
                    String cPassword = request.getParameter("cpassword");

                    if (!oPassword.equals(nPassword)) {
                        if (nPassword.equals(cPassword)) {
                            updatePstat.setString(1, nPassword);
                            updatePstat.setString(2, ForgetPasswordServ.email);
                            updatePstat.executeUpdate();
                            response.sendRedirect("Login.jsp?error=Password changed successfully");
                        } else {
                            response.sendRedirect("ChangePasswordPageJSP.jsp?error=Both passwords should be the same.");
                        }
                    } else {
                        response.sendRedirect("ChangePasswordPageJSP.jsp?error=Password should not be the same as the previous one.");
                    }
                } else {
                    response.sendRedirect("ChangePasswordPageJSP.jsp?error=User not found.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ChangePasswordPageJSP.jsp?error=Error: " + e.getMessage());
        }
    }
}

