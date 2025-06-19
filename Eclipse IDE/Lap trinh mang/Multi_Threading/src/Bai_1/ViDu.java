package Bai_1;



public class ViDu {

	public static void main(String[] args) {
		// Máy tính sẽ thực hiện code theo thứ tự từ trên xuống 
		System.out.println("Dong thu -1");
		Thread th = new TaskA();
		th.start();
		Thread rn = new Thread(new TaskB());
		rn.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("Dong thu "+i);
		}
		System.out.println("Ket thuc");
		
	}
}
