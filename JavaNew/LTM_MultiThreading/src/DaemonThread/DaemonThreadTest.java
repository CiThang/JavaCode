package DaemonThread;

public class DaemonThreadTest {

	public static void main(String[] args) {
		Thread dt = new Thread(new WorkingThread(),"My Daemon Thread");
		dt.setDaemon(true);
		dt.start();

		
		// tiep tuc chuong trinh
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">><< Finishing main program");
	}
}
