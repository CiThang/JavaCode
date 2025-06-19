package Yelp_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Database.JDBCUtil;
import Yelp_Model.YelpPost;
import Yelp_Model.YelpPrimaryKey;
import Yelp_View.YelpMainView;

public class YelpMainDAO {

	YelpMainView mainView;
	public static YelpMainDAO getInstance() {
		return new YelpMainDAO();
	}

	public void themDuLieuBaiDanhGia(YelpPost post) {
		int ketqua = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO BaiDanhGia (TaiKhoan, Email, BaiDanhGia, AnhDanhGia, TheLoai, GiaTien, DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(sql);

			// Thay thế các tham số trong câu lệnh SQL với giá trị thực
			pst.setString(1, YelpPrimaryKey.getInstance().getTaikhoan()); 
			pst.setString(2, YelpPrimaryKey.getInstance().getGmail()); 
			pst.setString(3, post.getBaiDanhGia()); 
			pst.setString(4, post.getAnhDanhGia()); 
			pst.setString(5, post.getTheLoai()); 
			pst.setDouble(6, post.getGiaTien());
			pst.setString(7, post.getDiaChi()); 

			// Thực thi câu lệnh SQL để chèn dữ liệu
			ketqua = pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(mainView, "Thêm thất bại");
		}
	}
}
