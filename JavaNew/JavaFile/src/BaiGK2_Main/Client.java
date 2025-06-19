
package BaiGK2_Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class Client {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			// Kết nối tới server
			int port = 10;
			Socket socket = new Socket("localhost", port);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			Scanner sc = new Scanner(System.in);

			String message;
			String line = null;
			String fileName = "D:\\Documents\\testJava\\a.txt"; 
            BufferedReader br = new BufferedReader(new FileReader(fileName));
               
               line = br.readLine();
                    
			
				// Gủi tin nhắn
				System.out.println("Client: ");
			
				writer.println(line);
				writer.flush();
				// Nhận tin nhắn
				message = reader.readLine();
				System.out.println(message);
			

		} catch (Exception e) {
			System.out.println("Không thể kết nối đến server");
		}
	}

}
