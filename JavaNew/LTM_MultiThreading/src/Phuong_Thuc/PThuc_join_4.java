package Phuong_Thuc;

public class PThuc_join_4 extends Thread {

	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
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
		PThuc_join_4 t1 = new PThuc_join_4();
		PThuc_join_4 t2 = new PThuc_join_4();
		PThuc_join_4 t3 = new PThuc_join_4();
		
		t1.start();
		try {
			t1.join(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		t3.start();
	}
	
}
