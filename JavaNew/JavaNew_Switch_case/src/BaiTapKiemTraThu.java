import java.util.Scanner;

public class BaiTapKiemTraThu {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so nguyen tu 0 den 8: ");
		n = sc.nextInt();

		switch (n) {
			case 2: {
				System.out.println("Thứ hai");
				break;
			}
			case 3: {
				System.out.println("Thứ ba");
				break;
			}
			case 4: {
				System.out.println("Thứ tư");
				break;
			}
			case 5: {
				System.out.println("Thứ năm");
				break;
			}
			case 6: {
				System.out.println("Thứ sáu");
				break;
			}
			case 7: {
				System.out.println("Thứ bảy");
				break;
			}
			case 8: {
				System.out.println("Chủ Nhật");
				break;
			}
			default:
				System.out.println("Nhap du lieu sai");
			}
		}
}