package Bai_1;

public class TaskChan extends Thread {
	private int n;

	public TaskChan(int n) {
		super();
		this.n = n;
	}
	@Override
	public void run() {
		for(int i=0; i<=n; i+=2) {
			System.out.println(i);
		}
	}
}
