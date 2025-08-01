package Phuong_Thuc;

class Mytd implements Runnable {
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Bắt đầu thread: " + t.getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Kết thúc thread:" + t.getName());
	}
}

public class PThuc_join_2 {
	public static void main(String[] args) {
		Thread th1 = new Thread(new Mytd(), "th1");
		Thread th2 = new Thread(new Mytd(), "th2");
		Thread th3 = new Thread(new Mytd(), "th3");
		// khởi chạy thread 1.
		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// khởi chạy thread 2.
		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// khởi chạy thread 3.
		th3.start();
		try {
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
