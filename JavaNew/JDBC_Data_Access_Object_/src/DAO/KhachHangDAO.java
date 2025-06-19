package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.KhachHang;
import Model.Sach;

public class KhachHangDAO implements DAOInteface<KhachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	
	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO KHACHHANG (ID, hoVaTen, ngaySinh, diaChi)" 
					+ "VALUES ('" + t.getId()+" ', '"+t.getHoVaTen()+"' , '"+t.getNgaySinh()+ "' , '"+t.getDiaChi() + "')";
			
			System.out.println("Ban thuc thi cau lenh : "+sql);
			
			ketQua = st.executeUpdate(sql);
			System.out.println("Co: "+ketQua+" dong bi thay doi");

			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selecAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM KHACHHANG";
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String hoVaTen = rs.getString("hoVaTen");
				Date giaBan = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				
				KhachHang khachHang = new KhachHang(id, hoVaTen, giaBan, diaChi);
				ketQua.add(khachHang);
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
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM KHAHHANG where id= '"+t.getId()+"'";
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				
				ketQua  = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				
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
	public ArrayList<KhachHang> selectByCondition(String condition) {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			// Buoc 1: tao ket noi
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement
			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM KHACHHANG where "+condition;
			
			System.out.println("Ban da thuc thi: "+sql);
			ResultSet rs = st.executeQuery(sql);
			// Buoc 4: 
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				
				KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				ketQua.add(khachHang);
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
