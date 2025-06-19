package BaiTap;
import java.net.*;

public class Bai2_server {
    public static void main(String[] args) {
        try {
            // Create a datagram socket for receiving data
            DatagramSocket socket = new DatagramSocket(12345);
            System.out.println("Server is running...");

            // Array of strings
            String[] elements = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

            while (true) {
                // Create a datagram packet for receiving data
                byte[] receiveData = new byte[4];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Receive data from the client
                socket.receive(receivePacket);

                // Convert received data to integer
                int number = byteArrayToInt(receiveData, 0);

                // Check if the number is within the valid range
                if (number >= 1 && number <= 10) {
                    // Get the corresponding element from the array
                    String element = elements[number - 1];

                    // Send the element back to the client
                    byte[] sendData = element.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(sendPacket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int byteArrayToInt(byte[] b, int offset) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (b[i + offset] & 0x000000FF) << shift;
        }
        return value;
    }
}
