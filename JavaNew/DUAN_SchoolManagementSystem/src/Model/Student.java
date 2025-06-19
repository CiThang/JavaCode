package Model;

import java.util.Date;
import java.util.Objects;

public class Student {

	private int maHocSinh;
	private String hoTen;
	private String lop;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private Tinh queQuan;
	private float diemToan;
	private float diemVan;
	private float diemAnh;
	private String anh;
	public Student() {
		super();
	}
	
	
	public Student(int maHocSinh, String hoTen, String lop,boolean gioiTinh ,Date ngaySinh, String diaChi, Tinh queQuan, float diemToan,
			float diemVan, float diemAnh, String anh) {
		super();
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.lop = lop;
		this.gioiTinh=gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.queQuan = queQuan;
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;
		this.anh = anh;
	}


	public Student(int maHocSinh, String hoTen, String lop,boolean gioiTinh, Date ngaySinh, String diaChi, Tinh queQuan, String anh) {
		super();
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.lop = lop;
		this.gioiTinh=gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.queQuan = queQuan;
		this.anh= anh;
	}


	public String getAnh() {
		return anh;
	}


	public void setAnh(String anh) {
		this.anh = anh;
	}

	
	
	public Student(int maHocSinh, float diemToan, float diemVan, float diemAnh) {
		super();
		this.maHocSinh = maHocSinh;
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;
	}


	public Student(int maHocSinh, String hoten,String lop ,float diemToan, float diemVan, float diemAnh) {
		super();
		this.hoTen = hoten;
		this.maHocSinh = maHocSinh;
		this.lop = lop;
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;
	}
	public int getMaHocSinh() {
		return maHocSinh;
	}
	public void setMaHocSinh(int maHocSinh) {
		this.maHocSinh = maHocSinh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Tinh getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}
	public float getDiemToan() {
		return diemToan;
	}
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}
	public float getDiemVan() {
		return diemVan;
	}
	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}
	public float getDiemAnh() {
		return diemAnh;
	}
	public void setDiemAnh(float diemAnh) {
		this.diemAnh = diemAnh;
	}


	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}



	


	@Override
	public String toString() {
		return "Student [maHocSinh=" + maHocSinh + ", hoTen=" + hoTen + ", lop=" + lop + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", queQuan=" + queQuan + ", diemToan=" + diemToan
				+ ", diemVan=" + diemVan + ", diemAnh=" + diemAnh + ", anh=" + anh + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(diaChi, diemAnh, diemToan, diemVan, gioiTinh, hoTen, lop, maHocSinh, ngaySinh, queQuan);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(diaChi, other.diaChi)
				&& Float.floatToIntBits(diemAnh) == Float.floatToIntBits(other.diemAnh)
				&& Float.floatToIntBits(diemToan) == Float.floatToIntBits(other.diemToan)
				&& Float.floatToIntBits(diemVan) == Float.floatToIntBits(other.diemVan) && gioiTinh == other.gioiTinh
				&& Objects.equals(hoTen, other.hoTen) && Objects.equals(lop, other.lop) && maHocSinh == other.maHocSinh
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(queQuan, other.queQuan);
	}
	
	
}
