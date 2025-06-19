package DaemonThread;

public class WorkingThread implements Runnable {

	@Override
	public void run() {
		while(true) {
			processSomething();
		}
	}
	
	private void processSomething() {
		try {
			System.out.println("Processing working thread");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
