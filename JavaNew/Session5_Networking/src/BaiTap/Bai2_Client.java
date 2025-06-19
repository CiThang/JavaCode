package BaiTap;

import java.net.*;

public class Bai2_Client {
    public static void main(String[] args) {
        try {
            // Create a datagram socket for sending data
            DatagramSocket socket = new DatagramSocket();

            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            // Send a number between 1 and 10 to the server
            int number = (int) (Math.random() * 10) + 1;
            byte[] sendData = intToByteArray(number);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            // Receive the element from the server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            // Convert received data to string and print
            String element = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received element: " + element);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] intToByteArray(int value) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            int offset = (b.length - 1 - i) * 8;
            b[i] = (byte) ((value >>> offset) & 0xFF);
        }
        return b;
    }
}
