package ViDu;

import java.io.File;
import java.io.IOException;

public class Taotaptin_Taothumuc {

	public static void main(String[] args) {
		// Luu y 
		// MS Windows: \ => \\
		// Linux, MacOs: /
		
		// Kiem tra thu muc tap tin da ton tai hay chua
		File folder1 = new File("D:\\FileCode\\Java\\JavaNew\\JavaFile_TaoFile");
		File folder2 = new File("D:\\FileCode\\Java\\JavaNew\\JavaFile_TaoFile1");

		System.out.println("Kiem tra folder1 co ton tai hay khong: " + folder1.exists());
		System.out.println("Kiem tra folder2 co ton tai hay khong: " + folder2.exists());
		
		// Tao thu muc
		// Phuong thuc mkdir()
		File folder3 = new File("D:\\Documents\\testJava");
//		folder3.mkdir();
		System.out.println("Kiem tra folder3 co ton tai hay khong: " + folder3.exists());
		
		
		// Tao nhieu thu muc cung luc
		// Phuong thuc mkdirs
		File folder4 = new File("D:\\Documents\\testJava2\\testJava2\\testJava3");
//		folder4.mkdirs();
		System.out.println("Kiem tra folder4 co ton tai hay khong: "+ folder4.exists());
		
		
		// Tao tap tin co phan mo rong: .exe, .txt, .doc
		// Phuong thuc createNewFile
		File file1 = new File("D:\\Documents\\testJava1\\testJava2\\testJava3.txt");
		try {
			file1.createNewFile	();
		} catch (IOException e) {
			// Khong co quyen tao tap tin
			// O cung bi day
			// Duong dan sai
			e.printStackTrace();
		}
	}
}
