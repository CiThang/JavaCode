package BaiTap2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DocFIlePart2 {

	public static void main(String[] args) {
		
		try {

			File filexml = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_BaiTap\\src\\BaiTap2\\NewFilePart2.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filexml);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("=="+doc.getDocumentElement().getNodeName());
			System.out.println("==========================================");
			
			NodeList nodeList = doc.getElementsByTagName("student");
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					System.out.println("id: "+element.getElementsByTagName("id").item(0).getTextContent());
					System.out.println("name: "+element.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("age: "+element.getElementsByTagName("age").item(0).getTextContent());
					System.out.println("===================================");
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
