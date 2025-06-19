package Bai_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
		System.out.println("Nhap n");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Thread th = new TaskChan(n);
		Thread th1 = new TaskLe(n);
		th1.start();
		th.start();
		
	}
}
