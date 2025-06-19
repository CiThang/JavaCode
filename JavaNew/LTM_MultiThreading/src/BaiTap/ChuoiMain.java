package BaiTap;

public class ChuoiMain {

	public static void main(String[] args) {
		Thread t = new Chuoi1();
		Thread t1 = new Chuoi2();
		
		try {
			t1.start();
			t.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
