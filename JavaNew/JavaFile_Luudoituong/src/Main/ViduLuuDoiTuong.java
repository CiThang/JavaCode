package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ViduLuuDoiTuong {

	public static void main(String[] args) {
		try {
			File file = new File("D:\\FileCode\\Java\\output.txt");
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			SinhVien st = new SinhVien("001","Thang",2005,10);
			oos.writeObject(st);
			
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
