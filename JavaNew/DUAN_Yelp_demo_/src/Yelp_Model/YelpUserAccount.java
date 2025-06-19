package Yelp_Model;

import java.util.Date;

public class YelpUserAccount {
	
	private String hoNguoiDung;
	private String tenNguoiDung;
	private String taiKhoanNguoiDung;
	private String emailNguoiDung;
	private String matKhauNguoiDung;
	private Date ngaySinhNguoiDung;
	private String anhDaiDien; 
	
	public YelpUserAccount(String hoNguoiDung, String tenNguoiDung, String taiKhoanNguoiDung, String emailNguoiDung,
			String matKhauNguoiDung, Date ngaySinhNguoiDung, String anhDaiDien) {
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.taiKhoanNguoiDung = taiKhoanNguoiDung;
		this.emailNguoiDung = emailNguoiDung;
		this.matKhauNguoiDung = matKhauNguoiDung;
		this.ngaySinhNguoiDung = ngaySinhNguoiDung;
		this.anhDaiDien = anhDaiDien;
	}
	public YelpUserAccount(String taiKhoanNguoiDung, String matKhauNguoiDung) {
		this.taiKhoanNguoiDung = taiKhoanNguoiDung;
		this.matKhauNguoiDung = matKhauNguoiDung;
	}
	public YelpUserAccount() {
	}
	public String getHoNguoiDung() {
		return hoNguoiDung;
	}
	public void setHoNguoiDung(String hoNguoiDung) {
		this.hoNguoiDung = hoNguoiDung;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	public String getTaiKhoanNguoiDung() {
		return taiKhoanNguoiDung;
	}
	public void setTaiKhoanNguoiDung(String taiKhoanNguoiDung) {
		this.taiKhoanNguoiDung = taiKhoanNguoiDung;
	}
	public String getEmailNguoiDung() {
		return emailNguoiDung;
	}
	public void setEmailNguoiDung(String emailNguoiDung) {
		this.emailNguoiDung = emailNguoiDung;
	}
	public String getMatKhauNguoiDung() {
		return matKhauNguoiDung;
	}
	public void setMatKhauNguoiDung(String matKhauNguoiDung) {
		this.matKhauNguoiDung = matKhauNguoiDung;
	}
	public Date getNgaySinhNguoiDung() {
		return ngaySinhNguoiDung;
	}
	public void setNgaySinhNguoiDung(Date ngaySinhNguoiDung) {
		this.ngaySinhNguoiDung = ngaySinhNguoiDung;
	}
	
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	@Override
	public String toString() {
		return "YelpUserAccount [hoNguoiDung=" + hoNguoiDung + ", tenNguoiDung=" + tenNguoiDung + ", taiKhoanNguoiDung="
				+ taiKhoanNguoiDung + ", emailNguoiDung=" + emailNguoiDung + ", matKhauNguoiDung=" + matKhauNguoiDung
				+ ", ngaySinhNguoiDung=" + ngaySinhNguoiDung + "]";
	}
	
	
	
	
}
