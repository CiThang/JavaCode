package Phuong_Thuc;

public class PThuc_sleep_2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread start");
		long startMain = System.currentTimeMillis();
		Thread.sleep(1000);
		Thread t = new Thread(() -> {
			System.out.println("Child thread start");
			try {
				long start = System.currentTimeMillis();
				Thread.sleep(1000);
				System.out.println("Child thread: "+ (System.currentTimeMillis()-start));
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		});
		t.start();
		System.out.println("Main thread: "+(System.currentTimeMillis()-startMain));
	}
}
