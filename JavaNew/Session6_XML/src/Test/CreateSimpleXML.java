package Test;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class CreateSimpleXML {
    public static void main(String[] args) {
        // Tên của tệp XML cần tạo
        String fileName = "example.xml";

        try {
            // Tạo một đối tượng XMLStreamWriter để ghi XML
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(fileName));

            // Bắt đầu viết XML
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("employees");

            // Tạo một phần tử nhân viên và thêm các thuộc tính
            xmlStreamWriter.writeStartElement("employee");
            xmlStreamWriter.writeAttribute("id", "1");

            // Thêm các thông tin của nhân viên
            xmlStreamWriter.writeStartElement("name");
            xmlStreamWriter.writeCharacters("John Doe");
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement("position");
            xmlStreamWriter.writeCharacters("Software Engineer");
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndElement(); // Kết thúc phần tử nhân viên

            // Kết thúc phần tử chính
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();

            // Đóng XMLStreamWriter
            xmlStreamWriter.close();

            System.out.println("File XML đã được tạo thành công: " + fileName);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
