import java.util.Scanner;

public class BtHinhTron {
	public static void main(String[] args) {
		double r, dienTich, chuVi;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ban kinh r: ");
		r = sc.nextDouble();
		
		// Tinh chu vi
		chuVi = 2*Math.PI*r;
		System.out.println("Chu vi = "+ chuVi);
		System.out.println("Chu vi = "+ Math.round(chuVi));
		System.out.println("Chu vi = "+ Math.round(chuVi*100.0)/100.0);
		
		// Tinh dien tich
		dienTich = Math.PI * Math.pow(r,2);
		System.out.println("Dien tich = " + dienTich);
		System.out.println("Dien tich = " + Math.round(dienTich));
		System.out.println("Dien tich = " + Math.round(dienTich*100.0)/100.0);
	}
}