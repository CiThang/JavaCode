package Yelp_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Yelp_Model.YelpUserAccount;
import Yelp_View.YelpMainView;
import Yelp_View.YelpRegisterView;

public class YelpRegisterDAO {
	
	public static YelpRegisterDAO getInstance() {
		return new YelpRegisterDAO();
	}
	
//	public YelpMainView mainview = new YelpMainView();
	public YelpRegisterView yelpRegisterView;
	
	public void DangKi(YelpUserAccount user) {
		int ketqua=0;
		java.sql.Date sqlDate = new java.sql.Date(user.getNgaySinhNguoiDung().getTime());
		
			try {
				Connection con = JDBCUtil.getConnection();
				
				String sql = "INSERT INTO InformationUser (Ho, Ten, TaiKhoan, Email, MatKhau, NgaySinh, AnhDaiDien) VALUES(?,?,?,?,?,?,?) ";
				
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, user.getHoNguoiDung());
				pst.setString(2, user.getTenNguoiDung());
				pst.setString(3, user.getTaiKhoanNguoiDung());
				pst.setString(4, user.getEmailNguoiDung());
				pst.setString(5, user.getMatKhauNguoiDung());
				pst.setDate(6, sqlDate );
				pst.setString(7, user.getAnhDaiDien());
				
				ketqua = pst.executeUpdate();
				
				JDBCUtil.closeConnection(con);
				
				
				
			} catch (Exception e) {
				
			}
		} 
	
		
	
	// Kiem tra tai khoan co ton tai khong
	public boolean kiemtrataikhoantontai(YelpUserAccount taiKhoanNguoiDung) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        
	        String sql = "SELECT COUNT(*) AS count FROM InformationUser WHERE TaiKhoan = ? OR Email = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, taiKhoanNguoiDung.getTaiKhoanNguoiDung());
	        pst.setString(2, taiKhoanNguoiDung.getEmailNguoiDung());
	        
	        ResultSet resultSet = pst.executeQuery();
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt("count");
	            if (count > 0) {
	                JOptionPane.showMessageDialog(yelpRegisterView, "Tài khoản hoặc email đã tồn tại");
	                return false;
	            } 
	        }
	    } catch (Exception e) {
			yelpRegisterView.textFieldTenTaiKhoan.setText("");
			yelpRegisterView.textFieldEmail.setText("");
	    }
	    return true;
	}

	// Kiem tra email hop le 
	 public static boolean isValidEmail(String email) {
	        // Biểu thức chính quy để kiểm tra định dạng email
	        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	        
	        // Tạo pattern
	        Pattern pattern = Pattern.compile(regex);
	        
	        // Tạo matcher
	        Matcher matcher = pattern.matcher(email);
	        
	        // Trả về true nếu email hợp lệ, ngược lại trả về false
	        return matcher.matches();
	    }
}
