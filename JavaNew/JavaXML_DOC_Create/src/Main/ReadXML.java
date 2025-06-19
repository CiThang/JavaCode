package Main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	public static void main(String[] args) {
		try {
			File inputFile = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_Create\\src\\Main\\input.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuider = dbFactory.newDocumentBuilder();
			Document doc = dBuider.parse(inputFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Phan tu goc "+doc.getDocumentElement().getNodeName());
			
			NodeList nodelist = doc.getElementsByTagName("student");
			
			for(int i=0 ; i<nodelist.getLength();i++) {
				Node node = nodelist.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Rollno: "+element.getAttribute("rollno"));
					System.out.println("First name: "+element.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last name: "+element.getElementsByTagName("lastname").item(0).getTextContent());
				}
				System.out.println("-----------");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
