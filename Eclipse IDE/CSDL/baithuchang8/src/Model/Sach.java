package Model;

public class Sach {

	public String ID;
	public String tenSach;
	public String tenTacGia;
	public int namXB;
	public Sach(String iD, String tenSach, String tenTacGia, int namXB) {
		this.ID = iD;
		this.tenSach = tenSach;
		this.tenTacGia = tenTacGia;
		this.namXB = namXB;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	@Override
	public String toString() {
		return "Sach [ID=" + ID + ", tenSach=" + tenSach + ", tenTacGia=" + tenTacGia + ", namXB=" + namXB + "]";
	}
	
	
}
