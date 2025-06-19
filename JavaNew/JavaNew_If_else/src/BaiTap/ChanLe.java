package BaiTap;

import java.util.Scanner;

public class ChanLe {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so nguyen n: ");
		n = sc.nextInt();
		
		// Kiem tra tinh chan le
		if(n%2 == 0) {
			System.out.println(n + " la so chan");
		}else {
			System.out.println(n + " la so le");
		}
	}
}