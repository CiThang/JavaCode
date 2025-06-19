package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Model.Student;
import View.StudentSignView;
import View.StudentSystemView;
import View.TeacherSignView;
import View.TeacherSystemView;

public class TeacherSignDao {
	public TeacherSystemDao tsDao;
	public static TeacherSignDao getInstance() {
		return new TeacherSignDao();
	}
	
	public void Dangnhap(TeacherSignView tsv) {
		TeacherSignView TSV = new TeacherSignView();
		try {		
			Connection con = JDBCUtil.getConnection();
			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * FROM TeacherAccount WHERE MaGiaoVien=? AND MatKhau=?";
			try {
			    // Sử dụng prepareStatement thay vì prepareCall
			    PreparedStatement ps = con.prepareStatement(sql);
			    
			    // Thiết lập giá trị cho tham số
			    ps.setString(1, tsv.textField.getText());
			    ps.setString(2, tsv.passwordField.getText());

			    // Thực hiện truy vấn và nhận kết quả
			    ResultSet rs = ps.executeQuery();

			    if (tsv.textField.getText().equals("") || tsv.passwordField.getText().equals("")) {
			        JOptionPane.showMessageDialog(TSV, "Bạn chưa nhập thông tin");
			    } else if (rs.next()) {
			        // Nếu có bản ghi trong kết quả, tức là đăng nhập thành công
			    	tsv.setVisible(false);
			        tsv.dispose();
			        TeacherSystemView ts = new TeacherSystemView();
			        ts.setVisible(true);
			        ts.setLocationRelativeTo(null);	
			        ts.lblMaGiaoVien.setText(tsv.textField.getText());
			        JOptionPane.showMessageDialog(TSV, "Đăng nhập thành công");
			       
			    } else {
			        JOptionPane.showMessageDialog(TSV, "Đăng nhập thất bại");
			    }
			} catch (SQLException e2) {
			    // Xử lý ngoại lệ SQL
			    e2.printStackTrace();
			    JOptionPane.showMessageDialog(TSV, "Lỗi khi thực hiện truy vấn");
			}

					
			// Buoc 5: Dong CSDL
			JDBCUtil.closeConnection(con)	;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
