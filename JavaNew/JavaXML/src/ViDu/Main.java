package ViDu;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		
		try {
			// Tao moit doi tuong File de doc tai lieu XML
			File xmlFile = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML\\src\\ViDu\\Input.xml");
			
			// Tao mot doi tuong DocumentBuilderFactory de tao ra mot doi tuong Document
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			// Parse tai lieu XML vao mot doi tuong Document
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			// In ra ten cua phan tu goc (root) cua tai lieu XML
			System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
			System.out.println("-------------------");
			
			// Lay danh sach cac phan tu con ten la "book" trong tai lieu
			NodeList nodeList = doc.getElementsByTagName("book");
			
			// Duyet qua danh sach cac phan tu "book"
			for(int i=0; i<nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					// Chuyen doi Node thanh Element de truy cap cac phan tu con
					
					Element element = (Element) node;
					
		               // In ra thông tin về từng cuốn sách
                    System.out.println("Category: " + element.getAttribute("category"));
                    System.out.println("Title: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Author: " + element.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Year: " + element.getElementsByTagName("year").item(0).getTextContent());
                    System.out.println("Price: " + element.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("----------------------------");
					
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
