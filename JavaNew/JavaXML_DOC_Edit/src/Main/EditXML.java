package Main;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import java.io.*;
public class EditXML {

	public static void main(String[] args) {
			 
	        try {
	           File inputFile = new File("D:\\FileCode\\Java\\JavaNew\\JavaXML_DOC_Edit\\src\\Main\\input.xml");
	           DocumentBuilderFactory docFactory = 
	                   DocumentBuilderFactory.newInstance();
	           DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	           Document doc = docBuilder.parse(inputFile);
	           Node classStudent = doc.getFirstChild();
	           Node student1 = doc.getElementsByTagName("student").item(0);
	            
	           // sửa thuộc tính rollno của student1
	           NamedNodeMap attr = student1.getAttributes();
	           Node nodeAttr = attr.getNamedItem("rollno");
	           nodeAttr.setTextContent("10");
	 
	           // sửa firstname của student1
	           NodeList list = student1.getChildNodes();
	            
	           for (int temp = 0; temp < list.getLength(); temp++) {
	              Node node = list.item(temp);
	              if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                if("Vinh".equals(eElement.getTextContent())) {
	                   eElement.setTextContent("Test");
	                }
	              }
	           }
	            
	           // xóa student 2
	           Node student2 = doc.getElementsByTagName("student").item(1);
	           classStudent.removeChild(student2);
	 
	           // ghi nội dung được sửa ra console
	           TransformerFactory transformerFactory = 
	                   TransformerFactory.newInstance();
	           Transformer transformer = transformerFactory.newTransformer();
	           DOMSource source = new DOMSource(doc);
	           System.out.println("-----------Modified File-----------");
	           StreamResult consoleResult = new StreamResult(System.out);
	           transformer.transform(source, consoleResult);
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	     }
}
