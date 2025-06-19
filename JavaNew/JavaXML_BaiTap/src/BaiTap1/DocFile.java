package BaiTap1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DocFile {

	public static void main(String[] args) {
		try {
			File file = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_BaiTap\\src\\BaiTap1\\NewFile.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuider = dbFactory.newDocumentBuilder();
			Document doc = dBuider.parse(file);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
			System.out.println("================");
			
			NodeList nodeList = doc.getElementsByTagName("book");
			
			for(int i=0; i<nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					System.out.println("Category: "+element.getAttribute("category"));
					System.out.println("Title: "+element.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("Author: "+element.getElementsByTagName("author").item(0).getTextContent());
					System.out.println("Year: "+element.getElementsByTagName("year").item(0).getTextContent());
					System.out.println("Price: "+element.getElementsByTagName("price").item(0).getTextContent());
					System.out.println("=================");
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
