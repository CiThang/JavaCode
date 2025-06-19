package Phuong_Thuc;

public class PThuc_join_3 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=5;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		PThuc_join_3 t1 = new PThuc_join_3();
		PThuc_join_3 t2 = new PThuc_join_3();
		PThuc_join_3 t3 = new PThuc_join_3();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	}
}
