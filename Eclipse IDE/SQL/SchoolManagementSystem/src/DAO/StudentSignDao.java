package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Model.Student;
import Model.Tinh;
import View.StudentSignView;
import View.StudentSystemView;

public class StudentSignDao {

	public static StudentSignDao getInstance() {
		return new StudentSignDao();
	}

	public Tinh tinh = new Tinh();
	public StudentSystemView ss = new StudentSystemView();
	private java.util.Date javaDate;
	private Tinh queQuan;

	public void Dangnhap(StudentSignView sta) {
		StudentSignView SSV = new StudentSignView();
		try {
			Connection con = JDBCUtil.getConnection();
			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM StudentAccount WHERE MaHocSinh=? AND MatKhau=?";
			try {
				// Sử dụng prepareStatement thay vì prepareCall
				PreparedStatement ps = con.prepareStatement(sql);

				// Thiết lập giá trị cho tham số
				ps.setString(1, sta.textFieldMaHS.getText());
				ps.setString(2, sta.passwordField.getText());

				// Thực hiện truy vấn và nhận kết quả
				ResultSet rs = ps.executeQuery();

				if (sta.textFieldMaHS.getText().equals("") || sta.passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(SSV, "Bạn chưa nhập thông tin");
				} else if (rs.next()) {
					// Nếu có bản ghi trong kết quả, tức là đăng nhập thành công
					Student st = new Student();
					st.setMaHocSinh(Integer.valueOf(sta.textFieldMaHS.getText()));
					sta.setVisible(false);
					sta.dispose();

					ss.setVisible(true);
					ss.setLocationRelativeTo(null);
					try {
						ss.SetText(this.selectStudent(Integer.valueOf(sta.textFieldMaHS.getText())));
						ss.studentManagement.insert(this.selectStudent(Integer.valueOf(sta.textFieldMaHS.getText())));
					} catch (Exception e) {
						// TODO: handle exception
					}

					ss.lblMaThiSinh.setText(sta.textFieldMaHS.getText());

					JOptionPane.showMessageDialog(SSV, "Đăng nhập thành công");
				} else {
					JOptionPane.showMessageDialog(SSV, "Đăng nhập thất bại");
				}
			} catch (SQLException e2) {
				// Xử lý ngoại lệ SQL
				JOptionPane.showMessageDialog(SSV, "Đăng nhập thất bại");
			}

			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(SSV, "Đăng nhập thất bại");
		}
	}

	public Student selectStudent(int maHocSinh) {
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT MaHocSinh, HoTen, Lop, GioiTinh, NgaySinh, DiaChi, QueQuan, DiemToan, DiemVan, DiemAnh,Anh "
					+ "FROM Student WHERE MaHocSinh = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setInt(1, maHocSinh);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						String hoTen = rs.getString("HoTen");
						String lop = rs.getString("Lop");
						String gt = rs.getString("GioiTinh");
						String que = rs.getString("QueQuan");

						boolean gioitinh = "Nam".equals(gt);

						Date ngaysinh = rs.getDate("NgaySinh");

						if (ngaysinh == null) {
							javaDate = new java.util.Date(null);
						} else {
							javaDate = new java.util.Date(ngaysinh.getTime());
						}
						
						String diachi = rs.getString("DiaChi");

						float toan = rs.getFloat("DiemToan");
						float van = rs.getFloat("DiemVan");
						float anh = rs.getFloat("DiemAnh");

						String avata = rs.getString("Anh");
						if (que == null) {
							queQuan = Tinh.getTinhByID(0);
						} else {
							queQuan = Tinh.getTinhByTen(que);
						}

						JDBCUtil.closeConnection(con);

						Student st = new Student(maHocSinh, hoTen, lop, gioitinh, javaDate, diachi, queQuan, toan, van, anh,
								avata);
						return st;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception more appropriately
		}

		return null;
	}

}
