package Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Database.JDBCUtil;

public class TestJDBCUtil {

	public static void main(String[] args) {
		
		try {
			// Bước 1: Tạo kết nối 
			Connection connection = JDBCUtil.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st =connection.createStatement();
			
			// Bước 3: Thực thi một câu lệnh SQL
			String sql ="INSERT INTO PERSON(ID, last_name,first_name,gender,dob,income)\r \n"
					+ "VALUES (\'3\',\'Nguyen\', \'Van C\',\'M\', \'1996-05-10\',15000000)";
			
			int check =  st.executeUpdate(sql);
			
			// Bước 4: Xử lý kết quả
			System.out.println("So dong thay doi: "+check);
			if(check>0) {
				System.out.println("Them du lieu thanh cong");
			} else {
				System.out.println("Them du lieu that bai");
			}
			
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
