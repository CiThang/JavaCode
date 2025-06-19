package BaiTap;

import java.util.Scanner;

public class PTBacNhat {
	public static void main(String[] args) {
		// PTBN: ax+b = 0
		/*
		 * Neu a = 0
		 * 		Neu b = 0 => PT Vô số nghiệm
		 * 		Neu b != 0 => PT Vô nghiệm
		 * Neu a!=0
		 * 		Co nghiem x = -b/a
		 */
		
		double a,b,x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap a = ");
		a = sc.nextDouble();
		System.out.println("Nhap b = ");
		b = sc.nextDouble();
		
		if(a==0) {
			// Tinh huong a = 0
			if(b==0) {
				// Tinh huong a=0 va b=0
				System.out.println("Phương trình vô số nghiệm!");
			}else {
				// Tinh huong a=0 va b!=0
				System.out.println("Phương trình vô nghiệm!");
			}
		}else {
			// Tinh huong a !=0
			x = -b/a;
			System.out.println("Con nghiem x = "+ x);
		}
	}
}