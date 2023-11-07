import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest2 {
	public static void main (String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {//add user
			conn = DriverManager.getConnection("jdbc:mysql://localhost/lab8?user=root&password=harrison10399");
		    ps = conn.prepareStatement("INSERT INTO lab8.StudentInfo (Name, SID) VALUES (?, ?)");
		    ps.setString(1, "jillian"); // set name to "Jack Levent"
		    ps.setInt(2, 232); // set SID to 115
		    int rows = ps.executeUpdate();
		    if (rows > 0) {
		        System.out.println("User added successfully!");
		    }
		} catch (SQLException sqle) {
		    System.out.println("SQLException: " + sqle.getMessage());
		}
	}
}
