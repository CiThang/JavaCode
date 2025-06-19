package Model;

public class TimKiemModel {

	private String vanBan;
	private String tuKhoa;
	private String ketQua;
	
	public TimKiemModel() {
		this.vanBan = "";
		this.tuKhoa ="";
		this.ketQua="";
	}

	public String getVanBan() {
		return vanBan;
	}

	public void setVanBan(String vanBan) {
		this.vanBan = vanBan;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	
	public void timKiem() {
		
		int dem =0;
		int vitri = 0;
		while (true) {
			int i = this.vanBan.indexOf(this.tuKhoa, vitri);
			if(i==-1) {
				// tinh huong khong tim thay 
				break;
			} else {
				dem++;
				vitri = i+1;
			}
		}
		this.ketQua = "Kết quả: có "+ dem +" "+ this.tuKhoa;
	}
}
