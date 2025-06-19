package Main;

import java.io.File;

public class XoaFile {
	
	public static void xoaFile(File fx) {
		if(fx.isFile()) {
			System.out.println("Da xoa: "+fx.getAbsolutePath());
			// Xoa neu la tap tin
			fx.delete();
		} else if(fx.isDirectory()) {
			// Lay cac file con
			File[] mangCon = fx.listFiles();
			for (File file : mangCon) {
				// Xoa cac file con
				xoaFile(file);
			}
			
			// Xoa ban than thu muc sau khi xoa cac file con
			System.out.println("Da xoa: "+fx.getAbsolutePath());
			fx.delete();
			
		}
	}

	public static void main(String[] args) {
		
		File f0 = new File("D:\\Documents\\testJava1");
		File f0_1 = new File("D:\\Documents\\testJava1\\testJava2");
		File f = new File("D:\\Documents\\testJava1\\test.txt");
		
		f0.deleteOnExit(); // Xoa duoc vi thu muc rong
		XoaFile.xoaFile(f0);
	}
}
