package Yelp_Model;

public class YelpPost {

	private String TaiKhoan;
	private String Email;
	private String BaiDanhGia;
	private String TheLoai;
	private double GiaTien;
	private String DiaChi;
	private String AnhDanhGia;
	public YelpPost(String taiKhoan, String email, String baiDanhGia, String theLoai, double giaTien, String diaChi,
			String anhDanhGia) {
		TaiKhoan = taiKhoan;
		Email = email;
		BaiDanhGia = baiDanhGia;
		TheLoai = theLoai;
		GiaTien = giaTien;
		DiaChi = diaChi;
		AnhDanhGia = anhDanhGia;
	}
	public YelpPost() {
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getBaiDanhGia() {
		return BaiDanhGia;
	}
	public void setBaiDanhGia(String baiDanhGia) {
		BaiDanhGia = baiDanhGia;
	}
	public String getTheLoai() {
		return TheLoai;
	}
	public void setTheLoai(String theLoai) {
		TheLoai = theLoai;
	}
	public double getGiaTien() {
		return GiaTien;
	}
	public void setGiaTien(double giaTien) {
		GiaTien = giaTien;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getAnhDanhGia() {
		return AnhDanhGia;
	}
	public void setAnhDanhGia(String anhDanhGia) {
		AnhDanhGia = anhDanhGia;
	}
	
	
	
}
