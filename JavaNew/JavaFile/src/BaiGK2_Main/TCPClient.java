package BaiGK2_Main;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        // Địa chỉ và cổng của server
        String serverAddress = "localhost";
        int serverPort = 12345;

        try {
            // Tạo socket kết nối tới server
            Socket socket = new Socket(serverAddress, serverPort);

            // Tạo luồng để gửi dữ liệu đến server
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Đọc nội dung của file a.txt
            BufferedReader fileReader = new BufferedReader(new FileReader( "D:\\Documents\\testJava\\a.txt"));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            fileReader.close();

            // Gửi nội dung của file đến server
            outputStream.writeBytes(content.toString());

            // Đóng các luồng và socket khi hoàn thành
            outputStream.close();
            socket.close();

            System.out.println("Đã gửi nội dung của file đến server thành công.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
