package BaiTap;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int n;
		System.out.println("Nhap n: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		
		Thread chan = new chan(n);
		
		
		Thread le = new le(n);
	
		chan.start();
		le.start();
		
	}
}
