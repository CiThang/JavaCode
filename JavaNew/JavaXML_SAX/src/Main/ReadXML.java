package Main;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ReadXML {

	public static void main(String[] args) {
		try {
			File inputFile = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_SAX\\src\\Main\\input.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			UserHandler userHandler = new UserHandler();
			
			// Phan tich tai lieu XML
			saxParser.parse(inputFile, userHandler);
			
			// in list doi tuong student ra man hinh
			for (Student student : userHandler.getListStudents()) {
				System.out.println(student.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
