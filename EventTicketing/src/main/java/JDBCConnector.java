
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnector {
	Connection conn;
	Statement st;
	PreparedStatement ps;
	void JDBCConnector() {
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
	}
	void createTable(){
		try {//make table
			conn = DriverManager.getConnection("jdbc:mysql://localhost/lab9?user=root&password=harrison10399");
			Statement st = conn.createStatement();
			String query = "CREATE TABLE users (username VARCHAR(255), password VARCHAR(255), email VARCHAR(255), favorite_events VARCHAR(255), purchased_event_tickets INT)";
			st.executeUpdate(query);
			System.out.println("Table created successfully!");
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
		}
	}
	void insertUser() throws ClassNotFoundException{
		try {//add user
			try {
				   Class.forName("com.mysql.cj.jdbc.Driver");
				  } catch (ClassNotFoundException e) {
				   e.printStackTrace();
				  }
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/lab8?user=root&password=harrison10399");
		    ps = conn.prepareStatement("INSERT INTO lab8.StudentInfo (Name, SID) VALUES (?, ?)");
		    ps.setString(1, "Jill"); // set name to "Jack Levant"
		    ps.setInt(2, 172); // set SID to 115
		    int rows = ps.executeUpdate();
		    if (rows > 0) {
		        System.out.println("User added successfully!");
		    }
		} catch (SQLException sqle) {
		    System.out.println("SQLException: " + sqle.getMessage());
		}
	}
}
	