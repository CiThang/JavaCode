package bli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vidu {

	
	public static void main(String[] args) throws SQLException {
		  String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=BAI1;user=sa;password=120605;encrypt=false";

	        
	        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
	        	
	        	System.out.println("Connect thanh cong");
	        	
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}
