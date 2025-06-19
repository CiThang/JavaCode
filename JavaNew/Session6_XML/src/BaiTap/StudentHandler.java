package BaiTap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

class StudentHandler extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;
    boolean bGender = false;
    boolean bGrade = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            String rollNo = attributes.getValue("rollno");
            System.out.println("*****Student*****");
            System.out.println("Roll No: " + rollNo);
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("gender")) {
            bGender = true;
        } else if (qName.equalsIgnoreCase("grade")) {
            bGrade = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        } else if (bGender) {
            System.out.println("Gender: " + new String(ch, start, length));
            bGender = false;
        } else if (bGrade) {
            System.out.println("Grade: " + new String(ch, start, length));
            bGrade = false;
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("data.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            StudentHandler userhandler = new StudentHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



