package HoaDonCaPhe;


public class HoaDonCaPhe {
	private String tenLoaiCaPhe;
	private double giaTien1Kg;
	private double khoiLuong;

	public HoaDonCaPhe(String ten, double gia, double kl) {
		this.tenLoaiCaPhe = ten;
		this.giaTien1Kg = gia;
		this.khoiLuong = kl;
	}

	public double tinhTongTien() {
		return this.giaTien1Kg * this.khoiLuong;
	}

	public boolean kiemTraKhoiLuongLonHon(double kl) {
//		if (this.khoiLuong > kl) {
//			return true;
//		}else {
//			return false;
//		}

		return this.khoiLuong > kl;
	}

	public boolean kiemTraTongTienLonHon500K() {
		return this.tinhTongTien() > 500000;
	}

	public double giamGia(double x) {
		if (this.tinhTongTien() > 500000) {
			return (x / 100) * this.tinhTongTien();
		} else {
			return 0;
		}
	}
	
	public double giaSauKhiGiam(double x) {
		return this.tinhTongTien() - this.giamGia(x);
	}
}