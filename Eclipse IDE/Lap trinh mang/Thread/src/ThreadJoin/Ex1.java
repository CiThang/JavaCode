package ThreadJoin;

public class Ex1 {

	public static void main(String[] args) {
		Thread th1 = new Thread(new MyThread(), "th1");
		Thread th2 = new Thread(new MyThread(), "th2");
		Thread th3 = new Thread(new MyThread(), "th3");
		th1.start();
		th2.start();
		th3.start();
		
	}
}
class MyThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread t = Thread.currentThread();
		System.out.println("Bat dau thread: "+t.getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ket thuc thread:"+t.getName());
	}
}
