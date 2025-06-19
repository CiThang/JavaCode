package Bai2;

import java.util.Scanner;

public class Test {

	public static void check(String str ) throws FormulaException, OperatorException{
		
		String[] list = str.split(" ");
		if(list.length != 3) {
			throw new FormulaException();
		}
		
		if ((list[1].equals("+") || list[1].equals("-") || list[1].equals("*") || list[1].equals("/")) == false ) {
			throw new OperatorException();
		} 
		
		try
		{
			float a = Float.parseFloat(list[0]);
			float b = Float.parseFloat(list[2]);
			if (list[1].equals("+")) {
				System.out.println("Ket qua "+(a+b));
			} else if(list[1].equals("-")) {
				System.out.println("Ket qua "+(a-b));
			} else if(list[1].equals("*")) {
				System.out.println("Ket qua "+(a*b));
			} else if(list[1].equals("/")) {
				try {
					if(b!=0) {
						System.out.println("Ket qua "+(a/b));
					} else {
						float s = 5/0;
					}
				} catch (Exception e) {
					System.out.println("Khong the chia cho 0");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Khong the chuyen thanh float");
		}
	}
	
	public static void main(String[] args) {
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap chuoi: ");
			String str = sc.nextLine();
			check(str);
			sc.close();
		} catch (FormulaException | OperatorException | NumberFormatException e) {
			System.out.println(e.getMessage());
		} 
		
	}
}
