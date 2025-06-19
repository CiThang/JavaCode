package DoUuTien;

public class TestMultiPriority extends Thread {

	@Override
	public void run() {
		System.out.println("Đang chạy luồng: " + Thread.currentThread().getName());
		System.out.println("Độ ưu tiên là:"  + Thread.currentThread().getPriority());
	}
	
	public static void main(String[] args) {
		TestMultiPriority m1 = new TestMultiPriority();
		TestMultiPriority m2 = new TestMultiPriority();
		m1.setPriority(MIN_PRIORITY);
		m2.setPriority(MAX_PRIORITY);
		m1.start();
		m2.start();
	}
	
}
