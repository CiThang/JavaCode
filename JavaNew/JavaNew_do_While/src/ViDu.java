import java.util.Scanner;

public class ViDu {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Nhap vao n>0");
			n = sc.nextInt();
		}while(n<=0);
	}
}