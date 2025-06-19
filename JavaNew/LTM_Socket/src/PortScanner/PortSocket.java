package PortScanner;

import java.net.Socket;

// Tìm trên máy tính có bao nhiêu port đang mở
public class PortSocket {

	public static void main(String[] args) {
		checkPort("localhost");
	}

	public static void checkPort(String urlString) {
		int startPort = 1;
		int endPort = 100000;

		System.out.println("Đang quét các port của máy : " + urlString);

		for (int i = startPort; i <= endPort; i++) {
			try {
				Socket socket =  new Socket(urlString, i);
				System.out.println("Cổng "+i+" đang mở");
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Quét cổng hoàn tất");
	}
}
