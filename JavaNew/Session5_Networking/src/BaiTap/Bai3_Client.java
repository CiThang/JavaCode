package BaiTap;

import java.io.*;
import java.net.*;

public class Bai3_Client {
    private static final String MULTICAST_GROUP = "224.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create a multicast socket
            MulticastSocket multicastSocket = new MulticastSocket(PORT);

            // Join the multicast group
            InetAddress multicastGroup = InetAddress.getByName(MULTICAST_GROUP);
            multicastSocket.joinGroup(multicastGroup);

            // Create a thread to listen for messages from the server
            Thread receiverThread = new Thread(() -> {
                try {
                    while (true) {
                        // Receive message from server
                        byte[] buffer = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                        multicastSocket.receive(receivePacket);
                        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                        // Print the received message
                        System.out.println("Received from server: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            // Read input from the user and send it to the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Enter message: ");
                String message = userInput.readLine();

                // Send message to server
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, multicastGroup, PORT);
                multicastSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
