package Yelp_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Yelp_Model.YelpPrimaryKey;
import Yelp_View.YelpMainView;
import Yelp_View.YelpRegisterView;
import Yelp_View.YelpSignInView;

public class YelpSignInDAO {

	
	public static YelpSignInDAO getInstance() {
		return new YelpSignInDAO();
	}
	
	public void DangNhap(YelpSignInView sigiin) {
		 try (Connection con = JDBCUtil.getConnection();
		         PreparedStatement pst = con.prepareStatement("SELECT * FROM InformationUser WHERE TaiKhoan=? AND MatKhau=?")) {
		        
		        pst.setString(1, sigiin.textFieldtaikhoan.getText());
		        pst.setString(2, sigiin.passwordField.getText());
		        
		        ResultSet rs = pst.executeQuery();
		        if (sigiin.textFieldtaikhoan.getText().isEmpty() || sigiin.passwordField.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(sigiin, "Bạn chưa nhập thông tin");
		        } else if (rs.next()) {
		            // Nếu có bản ghi trong kết quả thì đăng nhập thành công
		            JOptionPane.showMessageDialog(sigiin, "Đăng nhập thành công");
		         
		            
		            sigiin.setVisible(false);
		            sigiin.dispose();
		            YelpMainView mainView = new YelpMainView();
		            mainView.setVisible(true);
		            mainView.setLocationRelativeTo(null);
		            
		            
		        } else {
		            JOptionPane.showMessageDialog(sigiin, "Tài khoản hoặc mật khẩu không đúng");
		        }
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(sigiin, "Đã xảy ra lỗi khi đăng nhập: " + e.getMessage());
		        e.printStackTrace();
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(sigiin, "Đã xảy ra lỗi khi đăng nhập: " + e.getMessage());
		        e.printStackTrace();
		    }
	}
	
	public void PrimaryKey(YelpSignInView sInView) {
	    Connection con = JDBCUtil.getConnection();

	    String sql = "SELECT Email FROM InformationUser WHERE TaiKhoan=?";

	    try {
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, sInView.textFieldtaikhoan.getText());

	        ResultSet rs = pst.executeQuery();

	        if(rs.next()) {
	            String email = rs.getString("Email");
	            
	            // Tạo đối tượng YelpPrimaryKey với thông tin vừa lấy được
	            YelpPrimaryKey primary = new YelpPrimaryKey();
	            primary.setTaikhoan(sInView.textFieldtaikhoan.getText());
	            primary.setGmail(email);
	           
	            // Sử dụng đối tượng YelpPrimaryKey tại đây nếu cần
	            // Ví dụ: primary.someMethod();
	        }
	        
	        rs.close();
	        pst.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	
}
