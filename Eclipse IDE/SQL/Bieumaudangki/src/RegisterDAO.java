import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {

	public static RegisterDAO getInstance() {
		return new RegisterDAO();
	}
	public void insert(RegisterModel rm) {
		
		String gioitinh = rm.isGioitinh() ? "Nam" :"Nu";
		java.sql.Date sqlDate = new java.sql.Date(rm.getNgaySinh().getTime());
		
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO  Information (HoTen, NgaySinh, Email, SDT, GioiTinh, QuocGia, Mota)  VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, rm.getHoten());
			pst.setDate(2, sqlDate);
			pst.setString(3, rm.getEmail());
			pst.setInt(4, rm.getSdt());
			pst.setString(5, gioitinh);
			pst.setString(6, rm.getQuocgia());
			pst.setString(7, rm.getMoTa());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//(HoTen, NgaySinh, Email, SDT, GioiTinh, QuocGia, Mota) 
	}
	
	
}
