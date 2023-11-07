import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newUsername = request.getParameter("NewUsername");
        String password = request.getParameter("NewPassword");
        String email = request.getParameter("email");
        String ConfirmPassword = request.getParameter("ConfirmPassword");
        if(!ConfirmPassword.equals(password) ) {
        	 String text = "Password and Confirm Password Do Not Match.";
             response.setContentType("text/html");
             PrintWriter pw = response.getWriter();
             pw.println("<script type='text/javascript'>");
             pw.println("window.location.replace('http://localhost:8081/practice/login.html');");
             pw.println("alert('" + text + "');");
             pw.println("</script>");       
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            response.sendRedirect("http://localhost:8081/practice/login.html");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Assignment 4?user=root&password=harrison10399");
            ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, newUsername);
            rs = ps.executeQuery();
            if (rs.next()) {
                String text = "Username already exists.";
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.println("<script type='text/javascript'>");
                pw.println("window.location.replace('http://localhost:8081/practice/login.html');");
                pw.println("alert('" + text + "');");
                pw.println("</script>");
                return;
            }
            ps.close();
            rs.close();
            PreparedStatement ps2 = null;
            ResultSet rs2 = null;
            ps2 = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
            ps2.setString(1, email);
            rs2 = ps2.executeQuery();
            if (rs2.next()) {
            	 String text = "Email already exists.";
                 response.setContentType("text/html");
                 PrintWriter pw = response.getWriter();
                 pw.println("<script type='text/javascript'>");
                 pw.println("window.location.replace('http://localhost:8081/practice/login.html');");
                 pw.println("alert('" + text + "');");
                 pw.println("</script>");
                return;
            }
            ps2.close();
            rs2.close();
            
            PreparedStatement ps3 = null;
            ps3 = conn.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
            ps3.setString(1, newUsername);
            ps3.setString(2, password);
            ps3.setString(3, email);
            int rows = ps3.executeUpdate();
            if (rows > 0) {
                System.out.println("User added successfully!");
                Cookie a = new Cookie("Username", newUsername);
                Cookie b = new Cookie(newUsername+"balance","3000");
                response.addCookie(a);
                response.addCookie(b);
                response.sendRedirect("http://localhost:8081/practice/index.html");
            }
            ps3.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.out.println("SQLException: " + sqle.getMessage());
            }
        }
    }
}
