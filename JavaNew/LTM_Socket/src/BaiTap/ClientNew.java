package BaiTap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientNew {

	public static void main(String[] args) {
		final String SERVER_ADDRESS = "localhost"; // Dia chi cua server
		final int PORT = 12345; // Cong ket noi
		
		try {
			// Kết nối đến server
			Socket socket = new Socket(SERVER_ADDRESS,PORT);
			System.out.println("Connected to server...");
			
			// Thiết lập các luồng giao tiếp
			// Luồng đọc dữ liệu từ server
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// Luồng ghi dữ liệu đến server
			PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
			
			// Đọc các tn nhắn từ server và hiển thị chúng
			new Thread(()->{
				try {
					String message;
					// Đọc tin nhắn từ server
					while((message = reader.readLine())!=null) {
						// Hiển thị tin nhắn
						System.out.println(message);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}	
			}).start();
			
			// Gửi tin nhắn đến server
			Scanner scanner = new Scanner(System.in);
			String message;
			while(true) {
				// Hiển thị promt
				System.out.println("Client: ");
				// Đọc tin nhắn từ người dùng
				message = scanner.nextLine();
				// Gửi tin nhắn đến server
				writer.print(message);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
