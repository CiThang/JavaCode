package Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayXMLFile {
    public static void main(String[] args) {
        // Đường dẫn tới file XML
        String fileName = "example.xml";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Đọc từng dòng của file và hiển thị ra màn hình
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

