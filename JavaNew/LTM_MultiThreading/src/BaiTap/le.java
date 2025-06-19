package BaiTap;

public class le extends Thread {
	
	private int n;
	
	
	
	public le(int n) {
		this.n = n;
	}



	@Override
	public void run() {
		for(int i=1; i<=n ;i+=2) {
			System.out.println(i);
		}
	}
}
