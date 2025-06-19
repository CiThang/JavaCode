package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	

	// Thực hiện kết nối
	public static Connection getConnection() {
		Connection c = null;
		try {
			
			// Đăng khi SQLServer với DriveManeger
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			
			// Các thông số
			String Url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolManagementSystem";
			// ;user=sa;password=120605;encrypt=false
			String userName ="sa";
			String passWord ="12062005";
			
			// Tạo kết nối
			c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=YelpDemo;user=sa;password=120605;encrypt=false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return c;
		
	}
	
	// Đóng kết nối
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
