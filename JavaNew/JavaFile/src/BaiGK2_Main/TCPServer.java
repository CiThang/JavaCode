package BaiGK2_Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        int port = 12345;

        try {
            // Tạo một ServerSocket để lắng nghe kết nối từ client
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server đã khởi động và đang lắng nghe cổng " + port);

            // Chấp nhận kết nối từ client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client đã kết nối.");

            // Tạo luồng đọc dữ liệu từ client
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Đọc dữ liệu từ client
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = inputStream.readLine()) != null) {
                content.append(line).append("\n");
            }

            // In nội dung nhận được từ client
            System.out.println("Nội dung từ client:");
            System.out.println(content.toString());

            // Đóng kết nối và các luồng khi hoàn thành
            inputStream.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
