package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ReadXML {

	public static void main(String[] args) {
		List<Student> listStudents;
        try {
            listStudents = ReadXML.readListStudents();
 
            // hiển thị các đối tượng student ra màn hình
            for (Student student : listStudents) {
                System.out.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
	}
	
	public static List<Student> readListStudents() throws XMLStreamException, FileNotFoundException {
		
		List<Student> listStudents = new ArrayList<>();
		Student student = null;
		String tagContent = null;
		
		File inputFile = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_StAX\\src\\Main\\input.xml");
		InputStream is = new FileInputStream(inputFile);
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(is);
		
		 // duyệt các phần tử student
        while (reader.hasNext()) {
            int event = reader.next();
 
            switch (event) {
            case XMLStreamConstants.START_ELEMENT:
                // tạo đối tượng student
                if ("student".equals(reader.getLocalName())) {
                    student = new Student();
                    student.setId(reader.getAttributeValue(0));
                }
                break;
 
            case XMLStreamConstants.CHARACTERS:
                // đọc nội dung của thẻ hiện tại
                tagContent = reader.getText().trim();
                break;
 
            case XMLStreamConstants.END_ELEMENT:
                switch (reader.getLocalName()) {
                case "student":
                    listStudents.add(student);
                    break;
                case "firstname":
                    student.setFirstName(tagContent);
                    break;
                case "lastname":
                    student.setLastName(tagContent);
                    break;
                case "marks":
                    student.setMarks(tagContent);
                    break;
                }
                break;
            }
        }
        return listStudents;
		
	}
}
