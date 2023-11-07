import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	int testing = 85;
    private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    	PreparedStatement ps = null;
    		try {
				   Class.forName("com.mysql.cj.jdbc.Driver");
				  } catch (ClassNotFoundException e) {
				   e.printStackTrace();
				  }
        	Connection conn = null;
        	try {
        	    conn = DriverManager.getConnection("jdbc:mysql://localhost/Assignment 4?user=root&password=harrison10399");
        	    ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        	    ps.setString(1, username);
        	    ps.setString(2, password);
        	    ResultSet rs = ps.executeQuery();

        	    if (rs.next()) {
        	        System.out.println("Logged in.");
        	        Cookie a = new Cookie("Username", username);
                    response.addCookie(a);
                    response.sendRedirect("http://localhost:8081/practice/index.html");

        	    } else {
        	    	String text = "Invalid Username or Password.";
                    response.setContentType("text/html");
                    PrintWriter pw = response.getWriter();
                    pw.println("<script type='text/javascript'>");
                    pw.println("window.location.replace('http://localhost:8081/practice/login.html');");
                    pw.println("alert('" + text + "');");
                    pw.println("</script>");
        	    }
        	} catch (SQLException sqle) {
        	    System.out.println("SQLException: " + sqle.getMessage());
        	} finally {
        	    try {
        	        if (ps != null) {
        	            ps.close();
        	        }
        	        if (conn != null) {
        	            conn.close();
        	        }
        	    } catch (SQLException e) {
        	        System.out.println("SQLException: " + e.getMessage());
        	    }
        	}

	}
}

