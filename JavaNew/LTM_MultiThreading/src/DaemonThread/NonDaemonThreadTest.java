package DaemonThread;

public class NonDaemonThreadTest {

	public static void main(String[] args) {
		Thread dt = new Thread(new WorkingThread(),"My non-thread");
		dt.start();
		
		// Tiếp tục chương trình
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">><< Finishing main program");
	}
}
