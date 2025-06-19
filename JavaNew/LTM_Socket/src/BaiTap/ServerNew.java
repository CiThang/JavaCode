package BaiTap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNew {

	public static void main(String[] args) {
		final int PORT = 12345;
		try {
			// Tạo một ServerSocket với cổng PORT
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Server is running... ");
			
			// Chờ một kết nối từ một cilent
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected: "+clientSocket);
			
			// Thiết lập các lường giao tiếp
			// Luồng đọc dữ liệu từ client
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// Luồng ghi dữ liệu đến client
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
			
			//Đọc các tin nhắn từ client và hiển thị chúng
			String message;
			while((message = reader.readLine())!=null) {
				System.out.println("Client: "+message);
				// Trả lại tin nhắn cho client
				writer.print("Server: Received - "+message);
			}
			
			// Đóng tài nguyên
			reader.close();
			writer.close();
			clientSocket.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
