package InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try {
			
			// Tao InputStreamReader de chuyen doi byte tu System.in thanh cac ky tu
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			
			// Tao BufferedReader de doc du lieu tu InputStreamReader mot cach hieu qua
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			System.out.println("Nhap vao mot dong van ban: ");
			
			// Doc dong van ban tu ban phim
			String line = bufferedReader.readLine();
			
			// In rea dong van ban vua nhap
			System.out.println("Ban vua nhap: "+line);
			
			bufferedReader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
