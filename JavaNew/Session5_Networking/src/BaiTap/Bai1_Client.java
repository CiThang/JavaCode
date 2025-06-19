package BaiTap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Bai1_Client {
	public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 12345);

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read two numbers from the user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first number: ");
            int num1 = Integer.parseInt(userInput.readLine());
            System.out.print("Enter the second number: ");
            int num2 = Integer.parseInt(userInput.readLine());

            // Send the numbers to the server
            out.println(num1 + "," + num2);

            // Receive the sum from the server
            int sum = Integer.parseInt(in.readLine());
            System.out.println("Sum of the numbers: " + sum);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
