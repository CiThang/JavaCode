package Test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class ReadXMLFile {
    public static void main(String[] args) {
        try {
            File inputFile = new File("D:\\FileCode\\Java\\JavaNew\\XML\\src\\Test\\input.xml"); // Tạo một đối tượng File đại diện cho tệp XML đầu vào
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); // Tạo một đối tượng DocumentBuilderFactory để xây dựng một DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); // Tạo một đối tượng DocumentBuilder từ DocumentBuilderFactory
            Document doc = dBuilder.parse(inputFile); // Phân tích tệp XML và tạo một Document
            doc.getDocumentElement().normalize(); // Chuẩn hóa cấu trúc của tài liệu XML
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // In ra tên phần tử gốc của tài liệu XML
            NodeList nodeList = doc.getElementsByTagName("item"); // Lấy danh sách các phần tử có tên là "item"
            System.out.println("----------------------------");

            for (int temp = 0; temp < nodeList.getLength(); temp++) { // Duyệt qua danh sách các phần tử
                Node node = nodeList.item(temp); // Lấy một nút từ danh sách
                if (node.getNodeType() == Node.ELEMENT_NODE) { // Kiểm tra nếu nút là một phần tử
                    Element element = (Element) node; // Ép kiểu nút sang một phần tử
                    System.out.println("Item ID: " + element.getAttribute("id")); // In ra giá trị của thuộc tính "id" của phần tử
                    System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent()); // In ra nội dung của phần tử con có tên "name"
                    System.out.println("Price: " + element.getElementsByTagName("price").item(0).getTextContent()); // In ra nội dung của phần tử con có tên "price"
                    System.out.println("Description: " + element.getElementsByTagName("description").item(0).getTextContent()); // In ra nội dung của phần tử con có tên "description"
                }
            }
        } catch (Exception e) { // Bắt các ngoại lệ
            e.printStackTrace(); // In ra thông báo lỗi
        }
    }
}
