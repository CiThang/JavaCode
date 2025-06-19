package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.Sach;

public class SachDAO implements DAOInteface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "INSERT INTO SACH(ID, tenSach, giaBan, namXuatBan)" 
					+ "VALUES ('" + t.getId()+" ', '"+t.getTenSach()+"' , '"+t.getGiaBan()+ "' , '"+t.getNamXuatBan() + "')";
			
			System.out.println("Ban da thuc thi: "+sql);
			
			// Buoc 4: 
			ketQua = st.executeUpdate(sql);
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
	public int update(Sach t) {
		int ketQua = 0;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "UPDATE SACH "
					+ "SET"
					+ "	tenSach =' "+t.getTenSach()+"',"
					+ " giaBan =' "+t.getGiaBan() +"',"
					+ " namXuatBan = '"+t.getNamXuatBan() +"'"
					+ "WHERE id ='"+ t.getId() +"'";

			
			System.out.println("Ban da thuc thi: "+sql);
			
			// Buoc 4: 
			ketQua = st.executeUpdate(sql);
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
	public int delete(Sach t) {
		int ketQua = 0;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "DELETE from SACH "
					+ "WHERE id ='"+ t.getId() +"'";

			
			System.out.println("Ban da thuc thi: "+sql);
			
			// Buoc 4: 
			ketQua = st.executeUpdate(sql);
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
	public ArrayList<Sach> selecAll() {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM SACH";
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				Float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				
				Sach sach = new Sach(id, tenSach, namXuatBan, namXuatBan);
				ketQua.add(sach);
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
	public Sach selectById(Sach t) {
		Sach ketQua = null;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM SACH where id= '"+t.getId()+"'";
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				Float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				
				ketQua  = new Sach(id, tenSach, namXuatBan, namXuatBan);
				
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
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM SACH where "+condition;
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				Float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				
				Sach sach = new Sach(id, tenSach, namXuatBan, namXuatBan);
				ketQua.add(sach);
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
