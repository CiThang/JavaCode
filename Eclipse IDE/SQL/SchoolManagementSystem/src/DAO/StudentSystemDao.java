package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;

import Model.Student;

public class StudentSystemDao {
	public static StudentSystemDao getInstance() {
		return new StudentSystemDao();
	}
	// Thêm thông tin thí sinh

	public void insert(Student s) {
		int ketQua = 0;
		String gioitinh = s.isGioiTinh() ? "Nam" : "Nu";
		java.sql.Date sqlDate = new java.sql.Date(s.getNgaySinh().getTime());

		try {
			// Buoc 1: Tao ket noi
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Student "
					+ "SET HoTen =  ?, Lop = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, QueQuan = ?, Anh=?"
					+ "WHERE MaHocSinh = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getHoTen());
			pst.setString(2, s.getLop());
			pst.setString(3, gioitinh);
			pst.setDate(4, sqlDate);
			pst.setString(5, s.getDiaChi());
			pst.setString(6, s.getQueQuan().getTenTinh());
			pst.setInt(8, s.getMaHocSinh());
			
			pst.setString(7, s.getAnh());
			// Buoc 4: Thuc hien truy van
			ketQua = pst.executeUpdate();

			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			// Xu ly ngoai le, co the in ra log hoac thong bao loi
			e.printStackTrace();
		}
	}

	
	public void ChangePassword(int maHocSinh, String newpass) {
		try {
			// Buoc 1: Tao ket noi
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE StudentAccount "
					+ "SET MatKhau = ?"
					+ "WHERE MaHocSinh = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, newpass);
			pst.setInt(2, maHocSinh);

			// Buoc 4: Thuc hien truy van
			pst.executeUpdate();

			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			// Xu ly ngoai le, co the in ra log hoac thong bao loi
			e.printStackTrace();
		}
		
	}
}
