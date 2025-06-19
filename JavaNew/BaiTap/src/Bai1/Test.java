package Bai1;

import java.util.Scanner;

public class Test {

	public static void check(String str ) throws FormulaException{
		
		String[] stringList = str.split(" ");
		if(stringList.length != 3) {
			throw new FormulaException("Khong du 3 thanh phan ");
		}
		System.out.println("Ban da nhap dung so luong thanh phan ");
//		float list[] = new float[3];
//		for(int i=0; i<=2 ;i++) {
//			list[i] = Float.parseFloat(stringList[i]);
//		}
		
		float a = Float.parseFloat(stringList[0]);
		float b = Float.parseFloat(stringList[1]);
		float c = Float.parseFloat(stringList[2]);
		
		float delta = (b*b -4*a*c);
		if(delta<0) {
			System.out.println("Phuong trinh vo nghiem ");
		} else if(delta ==0) {
			System.out.println("Phuong trinh co nghiem kep x = "+(-b/2*a));
		} else {
			System.out.println("Phuong trinh co 2 nghiem phan biet ");
			System.out.println("x1 = " + ((-b+Math.sqrt(delta))/(2*a)));
			System.out.println("x2 = " + ((-b-Math.sqrt(delta))/(2*a)));
		}
	}
	public static void main(String[] args) {
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap chuoi : ");
			String str = sc.nextLine();
			check(str);
		} catch (NumberFormatException e) {
			System.out.println("Nhung khong the chuyen thanh kieu du lieu float");
		} catch (FormulaException e) {
			System.out.println(e.getMessage());
		}
	}
}
