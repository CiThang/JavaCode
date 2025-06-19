package Date22_02_2024_Bài_7;

public class SinhVien {
	private int id;
	private String ten;
	private float diemtb;
	public SinhVien(int id, String ten, float diemtb) {
		super();
		this.id = id;
		this.ten = ten;
		this.diemtb = diemtb;
	}
	public SinhVien() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public float getDiemtb() {
		return diemtb;
	}
	public void setDiemtb(float diemtb) {
		this.diemtb = diemtb;
	}
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", ten=" + ten + ", diemtb=" + diemtb + "]";
	}
	
	
}
