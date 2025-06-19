import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DocFiletxt {
    public static void main(String[] args) {
        String fileName = "example.txt"; // Thay đổi thành đường dẫn của file bạn muốn đọc
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // In từng dòng trong file
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
