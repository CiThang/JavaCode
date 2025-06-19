package Date22_02_2024_Bài_7;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		QuanLySinhVien ql = new QuanLySinhVien();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("HỆ THỐNG QUẢN LÝ SINH VIÊN");
		
		int luachon=0;
		
		do {
			System.out.println("1. Nhập danh sách sinh viên \n"
					+ "2. Xem danh sách sinh viên \n"
					+ "3. Sắp xếp và hiển thị danh sách sinh viên theo điểm trung bình tăng dần \n"
					+ "4. Tìm kiếm sinh viên theo tên \n "
					+ "5. Thoát \\n");
			System.out.println("Nhập lựa chọn "); luachon = sc.nextInt();
			if(luachon==1) {
				System.out.println("ID" ); int id = sc.nextInt(); sc.nextLine();
				System.out.println("Tên: "); String ten = sc.next(); sc.nextLine();
				System.out.println("Điểm trung bình: "); float diem = sc.nextFloat();
				SinhVien sv = new SinhVien(id, ten, diem);
				ql.themSinhVien(sv);
			} else if(luachon==2) {
				ql.hienThiDanhSach();
			} else if(luachon==3) {
				ql. sapXepDiemTBTangdan();
				ql.hienThiDanhSach();
			} else if(luachon==4) {
				System.out.println("Nhập tên"); String ten = sc.next();
				ql.timKiem(ten);
			}
			
		} while(luachon!=5);
	}
}
