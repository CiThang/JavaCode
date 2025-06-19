package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMExample {

	public static void main(String[] args) {
		List<Student> listStudents = DOMExample.readListStudents();
		// Hien thi cac doi tuong student ra man hinh
		for (Student student : listStudents) {
			System.out.println(student.toString());
		}
		
	}
	
	
	public static List<Student> readListStudents(){
		List<Student> listStudents = new ArrayList<>();
		Student student = null;
		
		try {
			// Doc file xml vua tao
			File inputFile = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_DOC\\src\\Main\\input.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuider = dbFactory.newDocumentBuilder();
			Document doc = dBuider.parse(inputFile);
			
			// Chuan hoa cau truc XMl
			doc.getDocumentElement().normalize();
			
			// In phan tu goc ra man hinh
			System.out.println("Phan tu goc: " + doc.getDocumentElement().getNodeName());
			
			// Doc tat ca cac phan tu co ten the la "student"
			NodeList nodeListStudent = doc.getElementsByTagName("student");
			
			// Duyet cac phan tu student
			for(int i=0; i<nodeListStudent.getLength();i++) {
				student = new Student();
				Node nNode = nodeListStudent.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					student.setId(element.getAttribute("id"));
					student.setFirstName(element.getElementsByTagName("firstname").item(0).getTextContent());
					student.setLastName(element.getElementsByTagName("lastname").item(0).getTextContent());
					student.setMarks(element.getElementsByTagName("marks").item(0).getTextContent());
				}
				// add doi tuong student vao listStudent
				listStudents.add(student);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listStudents;
	}
}
