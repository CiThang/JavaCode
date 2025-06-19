import java.util.Calendar;
import java.util.Date;

public class RegisterModel {

	private String hoten;
	private Date ngaySinh;
	private String email;
	private int sdt;
	private boolean gioitinh;
	private String quocgia;
	private String moTa;
	public RegisterModel(String hoten, Date ngaySinh, String email, int sdt, boolean gioitinh, String quocgia,
			String moTa) {
		super();
		this.hoten = hoten;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.sdt = sdt;
		this.gioitinh = gioitinh;
		this.quocgia = quocgia;
		this.moTa = moTa;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getQuocgia() {
		return quocgia;
	}
	public void setQuocgia(String quocgia) {
		this.quocgia = quocgia;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public String toString() {
		return "RegisterModel [hoten=" + hoten + ", ngaySinh=" + ngaySinh + ", email=" + email + ", sdt=" + sdt
				+ ", gioitinh=" + gioitinh + ", quocgia=" + quocgia + ", moTa=" + moTa + "]";
	}
	
	
	
}
