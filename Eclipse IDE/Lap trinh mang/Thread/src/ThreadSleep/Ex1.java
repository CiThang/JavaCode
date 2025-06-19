package ThreadSleep;

public class Ex1 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(2000);
			System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//2000ms
		
	}
}
