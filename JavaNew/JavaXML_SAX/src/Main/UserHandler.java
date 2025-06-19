package Main;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {

	private String content;
	private Student student;
	private List<Student> listStudents = new ArrayList<>();
	
    @Override
    public void startElement(String uri, String localName, String qName, 
            Attributes attributes) throws SAXException {
        // tạo đối tượng Student khi bắt đầu thẻ "student"
        if ("student".equalsIgnoreCase(qName)) {
            student = new Student();
            student.setId(attributes.getValue("id"));
        }
    }
    
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	switch (qName) {
    	case "student":
    		// add doi tuong Student vao list khi gap the dong "student"
    		listStudents.add(student);
    		break;
    	case "firstname":
    		student.setFirstName(content);
    		break;
    	case "lastname":
    		student.setLastName(content);
    		break;
    	case "marks":
    		student.setMarks(content);
    		break;
    	}
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    	content = String.copyValueOf(ch,start,length).trim();
    }
    
    public List<Student> getListStudents(){
    	return listStudents;
    }
 
    public void setListStudent (List<Student> listStudents) {
    	this.listStudents = listStudents;
    }
}
