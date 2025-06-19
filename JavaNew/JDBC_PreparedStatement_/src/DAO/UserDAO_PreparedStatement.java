package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.User;

public class UserDAO_PreparedStatement implements DAOInteface<User> {

	public static UserDAO_PreparedStatement getInstance() {
		return new UserDAO_PreparedStatement();
	}

	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			String sql = "INSERT INTO Userr(username, password, hovaten)" 
					+ "VALUES (?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getHovaten());

			// Buoc 3: Thuc thi cau lenh SQL
			
			
			System.out.println("Ban da thuc thi: "+sql);
			
			// Buoc 4: 
			System.out.println("Co: "+ketQua+" dong bi thay doi");
			
			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			String sql = "UPDATE Userr "
					+ "SET"
					+ "	password =?"
					+ " hovaten =?"
					+ "WHERE username = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getHovaten());
			pst.setString(3, t.getUsername());
			// Buoc 3: Thuc thi cau lenh SQL
			

			
			System.out.println("Ban da thuc thi: "+sql);
			
			// Buoc 4: 
			ketQua = pst.executeUpdate(sql);
			System.out.println("Co: "+ketQua+" dong bi thay doi");
			
			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			
			String sql = "DELETE from Userr "
					+ "WHERE username = ?";

			
			PreparedStatement pst = con.prepareStatement(null);

			pst.setString(1, t.getUsername());
			// Buoc 3: Thuc thi cau lenh SQL
			
			
			System.out.println("Ban da thuc thi: "+sql);
			
			// Buoc 4: 
			ketQua = pst.executeUpdate(sql);
			System.out.println("Co: "+ketQua+" dong bi thay doi");
			
			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<User> selecAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM Userr";
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				User User = new User(username, password, hovaten);
				ketQua.add(User);
			}
			
			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public User selectById(User t) {
		User ketQua = null;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			
			String sql = "SELECT * FROM Userr where username= ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getUsername());
			
			// Buoc 3: Thuc thi cau lenh SQL
						
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = pst.executeQuery();
		
			// Buoc 4: 
			
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				ketQua  = new User(username, password, hovaten);
				
			}
			
			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}


	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM Userr where "+condition;
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				User User = new User(username, password, hovaten);
				ketQua.add(User);
			}
			
			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
