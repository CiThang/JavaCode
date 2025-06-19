package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ViDuGhiFile {

	

	public static void main(String[] args) {
//		PrintWriter pw = new PrintWriter(System.out);
//		pw.println("Hello world");
//		pw.flush();
		
		try {
			PrintWriter pw = new PrintWriter("D:\\Documents\\testJava\\java.txt");
			pw.println("Hello world");
			pw.println("Đây là Chí Thắng");
			pw.print(3.14);
			pw.print(" số pi");
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
