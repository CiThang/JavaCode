package BaiTap;

public class chan extends Thread {

	private int n;
	
	public chan(int n) {
		this.n = n;
	}



	@Override
	public void run() {
		for(int i=0; i<=n; i+=2) {
			System.out.println(i);
		}
	}
}
