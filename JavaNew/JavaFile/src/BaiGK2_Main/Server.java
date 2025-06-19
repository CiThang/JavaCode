package BaiGK2_Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		final int PORT = 10;

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server is running...");
			while (true) {
				try (Socket clientSocket = serverSocket.accept()) {
					System.out.println("Client connected: " + clientSocket);

					try (BufferedReader reader = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream()));
							PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

						String message;
						while ((message = reader.readLine()) != null) {
							writer.println("Server: Received - " + message);
						}
						serverSocket.close();
					} 
				} 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
