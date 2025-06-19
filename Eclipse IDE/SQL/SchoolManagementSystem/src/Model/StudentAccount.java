package Model;

public class StudentAccount {

	private int maHocSinh;
	private String pass;
	public StudentAccount() {
		super();
	}
	public StudentAccount(int maHocSinh, String pass) {
		super();
		this.maHocSinh = 123;
		this.pass = "";
	}
	public int getMaHocSinh() {
		return maHocSinh;
	}
	public void setMaHocSinh(int maHocSinh) {
		this.maHocSinh = maHocSinh;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "StudentAccount [maHocSinh=" + maHocSinh + ", pass=" + pass + "]";
	}
	
}
