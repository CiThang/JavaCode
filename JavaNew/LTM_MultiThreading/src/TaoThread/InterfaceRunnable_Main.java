package TaoThread;

public class InterfaceRunnable_Main {

	public static void main(String[] args) {
		InterfaceRunnable td = new InterfaceRunnable();
		Thread thread = new Thread(td);
		thread.start();
	}
}
