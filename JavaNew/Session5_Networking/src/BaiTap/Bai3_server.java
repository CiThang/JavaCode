package BaiTap;

import java.io.*;
import java.net.*;

public class Bai3_server {
    private static final String MULTICAST_GROUP = "224.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create a multicast socket
            MulticastSocket multicastSocket = new MulticastSocket(PORT);

            // Join the multicast group
            InetAddress multicastGroup = InetAddress.getByName(MULTICAST_GROUP);
            multicastSocket.joinGroup(multicastGroup);

            System.out.println("Server is running...");

            // Create a thread to listen for messages from clients
            Thread receiverThread = new Thread(() -> {
                try {
                    while (true) {
                        // Receive message from client
                        byte[] buffer = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                        multicastSocket.receive(receivePacket);
                        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                        // Print the received message
                        System.out.println("Received from client: " + message);

                        // Broadcast the message to all clients in the multicast group
                        DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, multicastGroup, PORT);
                        multicastSocket.send(sendPacket);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
