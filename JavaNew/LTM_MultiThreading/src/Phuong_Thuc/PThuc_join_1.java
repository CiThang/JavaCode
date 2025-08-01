package Phuong_Thuc;

class YourThread implements Runnable {
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

public class PThuc_join_1 {
	public static void main(String[] args) {
		Thread th1 = new Thread(new YourThread(), "th1");
		Thread th2 = new Thread(new YourThread(), "th2");
		Thread th3 = new Thread(new YourThread(), "th3");
		th1.start();
		th2.start();
		th3.start();
	}
}
