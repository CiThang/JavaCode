package BaiTapMoRong;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running...");

            while (true) {
                // Wait for client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read the numbers and operation from the client
                String[] inputData = in.readLine().split(",");
                int num1 = Integer.parseInt(inputData[0]);
                int num2 = Integer.parseInt(inputData[1]);
                String operation = inputData[2];

                // Perform the requested operation
                int result;
                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "%":
                        result = num1 % num2;
                        break;
                    default:
                        out.println("Invalid operation");
                        clientSocket.close();
                        continue;
                }

                // Send the result back to the client
                out.println(result);

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
