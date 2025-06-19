package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Model.Student;
import Model.StudentManagement;
import Model.Tinh;
import View.TeacherSystemView;

public class TeacherSystemDao {

	public static TeacherSystemDao getInstance() {
		return new TeacherSystemDao();
	}
	
	public Tinh tinh = new Tinh();
	public TeacherSystemView tsv;
	private java.util.Date javaDate;
	private Tinh queQuan;
	
	public Student findStudent(int maHocSinh) {
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
						// Check if QueQuan is null before using getTenTinh()
						if (que == null) {
							queQuan = Tinh.getTinhByID(0);
						} else {
							queQuan = Tinh.getTinhByTen(que);
						}

						JDBCUtil.closeConnection(con);
						return new Student(maHocSinh, hoTen, lop, gioitinh, javaDate, diachi, queQuan, toan, van, anh,avata);
					}
				} catch (Exception e) {
//					JOptionPane.showMessageDialog(tsv, "Không có thông tin học sinh");
				}
			}
		} catch (SQLException e) {
			
		}

		return null;
	}
	public void Inputscore(Student st) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE Student "
					+ "SET DiemToan =? , DiemVan=?, DiemAnh=? "
					+ "WHERE MaHocSinh = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setFloat(1, st.getDiemToan());
			pst.setFloat(2, st.getDiemVan());
			pst.setFloat(3, st.getDiemAnh());
			pst.setInt(4, st.getMaHocSinh());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> Showlist() {
		ArrayList<Student> ketqua = new ArrayList<Student>();
		StudentManagement stm = new StudentManagement(ketqua);
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT MaHocSinh, HoTen,Lop , DiemToan , DiemVan, DiemAnh "
					+ "FROM Student ;";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int mahocsinh = rs.getInt("MaHocSinh");
				String hoten = rs.getString("HoTen");
				String lop = rs.getString("Lop");
				Float toan = rs.getFloat("DiemToan");
				Float van = rs.getFloat("DiemVan");
				Float anh = rs.getFloat("DiemAnh");
				
				Student student = new Student(mahocsinh, hoten,lop, toan, van,anh);
				ketqua.add(student);
						
			}
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public Student GetStudentByID(int maHocSinh) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        // Use prepared statement to avoid SQL injection
	        String sql = "SELECT MaHocSinh, HoTen, Lop , DiemToan, DiemVan, DiemAnh "
	                + "FROM Student "
	                + "WHERE MaHocSinh = ?";
	                
	        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setInt(1, maHocSinh);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                int maHocSinhResult = rs.getInt("MaHocSinh");
	                String hoTen = rs.getString("HoTen");
	                String lop = rs.getString("Lop");
	                Float diemToan = rs.getFloat("DiemToan");
	                Float diemVan = rs.getFloat("DiemVan");
	                Float diemAnh = rs.getFloat("DiemAnh");

	                return new Student(maHocSinhResult, hoTen,lop, diemToan, diemVan, diemAnh);
	            }
	        }
	        
	        JDBCUtil.closeConnection(con);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public void addID(int maHocSinh) {
	    try {
	        try (Connection con = JDBCUtil.getConnection();
	             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Student(MaHocSinh) VALUES (?)")) {

	            preparedStatement.setInt(1, maHocSinh);
	            int rowsAffected = preparedStatement.executeUpdate();
	        }

	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(tsv, "Học sinh này đã tồn tại");
	    }
	}
	
	public void delete(int maHocSinh) {
	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "DELETE FROM Student WHERE MaHocSinh = ?";
	        
	        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setInt(1, maHocSinh);
	            int rowsAffected = preparedStatement.executeUpdate();
	            
	        }

	        JDBCUtil.closeConnection(con);
	    } catch (Exception e) {
	        e.printStackTrace();
	       
	    }
	}
	
	public ArrayList<Student> selectStudentsByMath() {
	    ArrayList<Student> list = new ArrayList<Student>();

	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Student WHERE DiemToan = (SELECT MAX(DiemToan) FROM Student)");
	         ResultSet rs = preparedStatement.executeQuery()) {

	        while (rs.next()) {
	            int maHocSinh = rs.getInt("MaHocSinh");
	            String hoTen = rs.getString("HoTen");
	            String lop = rs.getString("Lop");
	            float diemToan = rs.getFloat("DiemToan");
	            float diemVan = rs.getFloat("DiemVan");
	            float diemAnh = rs.getFloat("DiemAnh");

	            Student student = new Student(maHocSinh, hoTen, lop, diemToan, diemVan, diemAnh);
	            list.add(student);
	           
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Nên in ra lỗi để dễ debug
	    }

	    return list;
	}
	public ArrayList<Student> selectStudentsByLiterature() {
	    ArrayList<Student> list = new ArrayList<Student>();

	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Student WHERE DiemVan = (SELECT MAX(DiemVan) FROM Student)");
	         ResultSet rs = preparedStatement.executeQuery()) {

	        while (rs.next()) {
	            int maHocSinh = rs.getInt("MaHocSinh");
	            String hoTen = rs.getString("HoTen");
	            String lop = rs.getString("Lop");
	            float diemToan = rs.getFloat("DiemToan");
	            float diemVan = rs.getFloat("DiemVan");
	            float diemAnh = rs.getFloat("DiemAnh");

	            Student student = new Student(maHocSinh, hoTen, lop, diemToan, diemVan, diemAnh);
	            list.add(student);
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Nên in ra lỗi để dễ debug
	    }

	    return list;
	}
	public ArrayList<Student> selectStudentsByEnglish() {
	    ArrayList<Student> list = new ArrayList<Student>();

	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Student WHERE DiemAnh = (SELECT MAX(DiemAnh) FROM Student)");
	         ResultSet rs = preparedStatement.executeQuery()) {

	        while (rs.next()) {
	            int maHocSinh = rs.getInt("MaHocSinh");
	            String hoTen = rs.getString("HoTen");
	            String lop = rs.getString("Lop");
	            float diemToan = rs.getFloat("DiemToan");
	            float diemVan = rs.getFloat("DiemVan");
	            float diemAnh = rs.getFloat("DiemAnh");

	            Student student = new Student(maHocSinh, hoTen, lop, diemToan, diemVan, diemAnh);
	            list.add(student);
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Nên in ra lỗi để dễ debug
	    }

	    return list;
	}
	
	public void ChangePassword(String magiaovien, String newpass) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql  = "UPDATE TeacherAccount "
					+ "SET MatKhau = ?"
					+ "WHERE MaGiaoVien = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, newpass);
			pst.setString(2, magiaovien);
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setAccount(int mahocsinh) {
		        try (Connection con = JDBCUtil.getConnection();
		             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO StudentAccount(MaHocSinh,MatKhau) VALUES (?,?)")) {
		            preparedStatement.setInt(1, mahocsinh);
		            preparedStatement.setString(2, "123");
		            int rowsAffected = preparedStatement.executeUpdate();
		        }

		    catch (Exception e1) {
		    	JOptionPane.showMessageDialog(tsv, "Tài khoản học sinh này đã tồn tại");
		    }
		}
	public void deleteAccount(int maHocSinh) {
	    try {
	        Connection con = JDBCUtil.getConnection();

	        String sql = "DELETE FROM StudentAccount WHERE MaHocSinh = ?";
	        
	        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setInt(1, maHocSinh);
	            preparedStatement.executeUpdate();
	            
	        }

	        JDBCUtil.closeConnection(con);
	    } catch (Exception e) {
	        e.printStackTrace();
	       
	    }
	}
}

