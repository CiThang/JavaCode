package ViDu;

import java.io.File;
import java.util.Scanner;

public class Laythongtin {
	
	File  file;
	
	
	
	
	public Laythongtin(String tenFile) {
		this.file = new File(tenFile);
	}
	
	public boolean kiemTraThucThi() {
		// Kiem tra co the thuc thi
		return this.file.canExecute();
	}
	
	public boolean kiemTraDoc() {
		// Kiem tra co the doc
		return this.file.canRead();
	}
	
	public boolean kiemTraGhi() {
		// Kiem tra co the ghi
		return this.file.canWrite();
	}

	public void inDuongDan() {
		// Lay duong dan
		System.out.println(this.file.getAbsolutePath());
	}
	
	public void inTen() {
		// In ten file
		System.out.println(this.file.getName());
	}
	
	public void kiemTraLaThuMucHoacTapTin() {
		// Kiem tra thu muc hay la tap tin
		if(this.file.isDirectory()) {
			System.out.println("Đây là thư mục");
		} else if(this.file.isFile()) {
			System.out.println("Đây là tập tin");
		}
	}

	public void inDanhSachCacFileCon() {
		if(this.file.isDirectory()) {
			System.out.println("Các tập tin con/ thư mục con là ");
			File[] mangCon = this.file.listFiles();
			for (File file : mangCon) {
				System.out.println(file.getAbsolutePath());
			}
		} else if(this.file.isFile()) {
			System.out.println("Đây là tập tin, không có dữ liệu con bên trong: ");
		}
	}
	
	public void inCayThuMuc() {
		this.inChiTietCayThuMuc(this.file,1);
	}
	
	public void inChiTietCayThuMuc(File f, int bac) {
		
		for(int i = 0; i<bac; i++) {
			System.out.print("\t");
		}
		System.out.print("|__");
		System.out.println(f.getName());
		if(f.canRead() && f.isDirectory()) {
			File[] mangCon = f.listFiles();
			for (File file : mangCon) {
				inChiTietCayThuMuc(file,bac+1);
			}
		}
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luachon = 0;
		System.out.println("Nhập tên File: ");
		String tenFile = sc.nextLine();
		Laythongtin file = new Laythongtin(tenFile);
		
		do {
			System.out.println("MENU----");
			System.out.println("1.Kiểm tra File có thể thực thi");
			System.out.println("2.Kiểm tra File có thể đọc");
			System.out.println("3.Kiểm tra File có thể ghi");
			System.out.println("4.In đường dẫn");
			System.out.println("5.In tên File");
			System.out.println("6.Kiểm tra File à thư mục hoặc tập tin");
			System.out.println("7.In ra danh sách các file con");
			System.out.println("8.In ra cây thư mục");
			System.out.println("0.Thoát chương trình");
			luachon = sc.nextInt();
			switch (luachon) {
			case 1: 
				System.out.println(file.kiemTraThucThi());
				break;
			case 2:
				System.out.println(file.kiemTraDoc());
				break;
			case 3:
				System.out.println(file.kiemTraGhi());
				break;
			case 4:
				file.inDuongDan();
				break;
			case 5:
				file.inTen();
				break;
			case 6:
				file.kiemTraLaThuMucHoacTapTin();
				break;
			case 7:
				file.inDanhSachCacFileCon();
				break;
			case 8:
				file.inCayThuMuc();
				break;
			}
			
			
		} while(luachon!=0);
	
} 
		}

