package BaiTap;

public class Chuoi1 extends Thread {

	@Override
	public void run() {
		chuoi();
	}
	public void chuoi() {
		for(int i=0; i<20; i++) {
			System.out.println("cc");
		}
	}
}
