package Test;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class OpenXMLFile {
    public static void main(String[] args) {
        try {
            // Tạo một đối tượng DocumentBuilderFactory để tạo một trình phân tích XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load file XML
            File xmlFile = new File("example.xml");
            Document document = builder.parse(xmlFile);

            // Lấy phần tử gốc
            Element root = document.getDocumentElement();
            System.out.println("Element gốc: " + root.getNodeName());

            // Lấy danh sách các phần tử con của phần tử gốc
            NodeList nodeList = root.getElementsByTagName("employee");

            // Lặp qua danh sách phần tử con và in ra thông tin
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String position = element.getElementsByTagName("position").item(0).getTextContent();
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Position: " + position);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
