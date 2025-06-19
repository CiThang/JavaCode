package BaiTapMoRong;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 12345);

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read two numbers and an operation from the user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first number: ");
            int num1 = Integer.parseInt(userInput.readLine());
            System.out.print("Enter the second number: ");
            int num2 = Integer.parseInt(userInput.readLine());
            System.out.print("Enter the operation (+, -, *, /, %): ");
            String operation = userInput.readLine();

            // Send the numbers and operation to the server
            out.println(num1 + "," + num2 + "," + operation);

            // Receive the result from the server
            int result = Integer.parseInt(in.readLine());
            System.out.println("Result: " + result);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
