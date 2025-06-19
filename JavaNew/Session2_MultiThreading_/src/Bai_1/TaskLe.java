package Bai_1;

public class TaskLe extends Thread {

	private int n;

	public TaskLe(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=n; i+=2) {
			System.out.println(i);
		}
	}
	
}
