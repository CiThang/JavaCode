package Bai3;

import java.util.Scanner;

public class Test {

	public static void check(int a, int b, int c) throws InvalidTriangleException {
//		try {
			if (a + b < c || a + c < b || b + c < a || a==0 || b==0 || c==0 || a+b==c || a+c==b || b+c==a) {
				throw new InvalidTriangleException();
			}
			System.out.print("Loai: ");
			if (a == b && b == c) {
				System.out.println("Day la tam giac deu");
			} else if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b) {
				System.out.println("Day la tam giac vuong");
			} else if (a == b || b == c || a == c) {
				System.out.println("Day la tam giac deu");
			} else {
				System.out.println("Day la tam giac thuong");
			}
//		} catch (NumberFormatException e) {
//			System.out.println("Sai du lieu ");
//		}
	}

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap 3 canh cua tam giac");
		try {
			String a = sc.nextLine();	int A = Integer.parseInt(a);
			String b = sc.nextLine();	int B = Integer.parseInt(b);
			String c = sc.nextLine();	int C = Integer.parseInt(c);
			
			check(A,B,C);
		} catch (NumberFormatException e) {
			System.out.println("Sai du lieu");
		} catch (InvalidTriangleException e) {
			System.out.println(e.getMessage());
		}
	}
}
