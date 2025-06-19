package Main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ViDu {

	public static void copyAll(File f1, File  f2) {
		try {
			// Copy ban than no
			Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(f1.isDirectory()) {
			// Copy cac tap tin va thu muc con
			File[] mangcon = f1.listFiles();	
			for (File file : mangcon) {
				File file_new = new File(f2.getAbsoluteFile()+"\\"+file.getName());
				copyAll(file, file_new);
			}
		
		}
	}
	public static void main(String[] args) {
		File f0 = new File("D:\\Documents\\testJava\\java1.txt");
		File f1 = new File("D:\\Documents\\testJava\\javaaaa.txt");
		File f2 = new File("D:\\Documents\\testJava\\javavava.txt");
		File f3 = new File("D:\\Documents\\testJava\\java2.txt");
		
//		// 1. Thay doi ten cua 1 file hay thu muc
//		// Su dung File de thay doi ten
//		f0.renameTo(f1);
//		
//		// Su dung File de thay doi ten
//		// f1.toPath() -> doi tuong duong dan
//		try {
//			Files.move(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		// 2. Di chuyen File 
//		File f3_new = new File("D:\\Documents\\testJava\\java\\java2.txt");
//		try {
//			Files.move(f3.toPath(),f3_new.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		// 3. Copy File 
//		File f_0 = new File("D:\\Documents\\testJava\\java\\java2.txt");
//		File f_0_copy = new File("D:\\Documents\\testJava\\java\\java2_copy.txt");
//		try {
//			Files.copy(f_0.toPath(), f_0_copy.toPath(),StandardCopyOption.REPLACE_EXISTING);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
		// Copy File all file
		File f_1 = new File("D:\\Documents\\testJava\\java");
		File f_1_copy = new File("D:\\Documents\\testJava\\java_copy");
		try {
			copyAll(f_1, f_1_copy);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
