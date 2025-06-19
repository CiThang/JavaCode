package BaiTap3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DocFilePart3 {

	public static void main(String[] args) {
		try {
			File file = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_BaiTap\\src\\BaiTap3\\NewFilePart3.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("==="+doc.getDocumentElement().getNodeName());
			
			NodeList nodeList = doc.getElementsByTagName("pheptinh");
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					int a = Integer.valueOf(element.getElementsByTagName("x").item(0).getTextContent());
					int b = Integer.valueOf(element.getElementsByTagName("y").item(0).getTextContent());
					
					System.out.println("x+y="+(a+b));
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
