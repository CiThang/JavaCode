package BufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		try {
			
			// Mo FileReader de doc tep "java.txt"
			FileReader fileReader = new FileReader("D:\\Documents\\testJava\\java.txt");
			
			// Tao BufferedReader de tan dung dung viec doc du lieu tu FileReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// Doc Tung dong trong trep bang phuong thuc readLine()
			String line;
			while((line = bufferedReader.readLine())!=null) {
				System.out.println(line);
			}
			
			// Dong BufferedReader sau khi hoan tat viec doc tep
			bufferedReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
