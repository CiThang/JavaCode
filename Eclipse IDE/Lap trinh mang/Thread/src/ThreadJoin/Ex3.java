package ThreadJoin;

public class Ex3 extends Thread {
	@Override
	public void run() {
		for(int i = 1; i<=5 ; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		Ex3 t1 = new Ex3();
		Ex3 t2 = new Ex3();
		Ex3 t3 = new Ex3();
		t1.start();
		try {
			// t1.join();
			t1.join(1500);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		t2.start();
		t3.start();
	}

}
