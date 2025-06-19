package Main;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import java.io.*;

public class CreateXML {

	public static void main(String[] args) {
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			// Tao phan tu goc
			Element rootElement = doc.createElement("class");
			doc.appendChild(rootElement);
			
			// Them thuoc tinh totalStudents vao the class
			Attr totalStudentAttr = doc.createAttribute("totalStudents");
			totalStudentAttr.setValue("2");
			rootElement.setAttributeNode(totalStudentAttr);
			
				// Tao phan tu Student1
				Element student1 = doc.createElement("student");
				rootElement.appendChild(student1);
			
				// tao thuoc tinh rollno cho student1
				Attr attr1 = doc.createAttribute("rollno");
				attr1.setValue("1");
				student1.setAttributeNode(attr1);
			
				// Tao the firstname
				Element firstname1 = doc.createElement("firstname");
				firstname1.appendChild(doc.createTextNode("Vinh"));
				student1.appendChild(firstname1);
			
				// Tao the lastname
				Element lastname1 = doc.createElement("lastname");
				lastname1.appendChild(doc.createTextNode("Phan"));
				student1.appendChild(lastname1);
			
				// Tao phan tu student2
				Element student2 = doc.createElement("student");
				rootElement.appendChild(student2);
			
				// Tao thuoc tinh rollno cho student2
				Attr attr2 = doc.createAttribute("rollno");
				attr2.setValue("2");
				student2.setAttributeNodeNS(attr2);
			
				// Tao the firstname
				Element firstname2 = doc.createElement("firstname");
				firstname2.appendChild(doc.createTextNode("Hoa"));
				student2.appendChild(firstname2);
			
				// Tao the lastname
				Element lastname2 = doc.createElement("lastname");
				lastname2.appendChild(doc.createTextNode("Nguyen"));
				student2.appendChild(lastname2);
			
			
			// ghi noi dung vao file XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_Create\\src\\Main\\input.xml"));
			
			transformer.transform(source, result);
			
			// ghi ket qua ra console de kiem tra
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
