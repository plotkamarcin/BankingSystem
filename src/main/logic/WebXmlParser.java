package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import data.Currency;

public class WebXmlParser {
	
	private String url="http://www.nbp.pl/kursy/xml/a079z150424.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	
	private void prepareToParse() throws ParserConfigurationException, SAXException, IOException{
		factory=DocumentBuilderFactory.newInstance();
		builder=factory.newDocumentBuilder();
		document=builder.parse(url);
		document.getDocumentElement().normalize();
	}
	
	private String parseFieldFromXml(Element e, String fieldName){
		NodeList list = e.getElementsByTagName(fieldName);
        Element element = (Element) list.item(0);
        Node name = element.getChildNodes().item(0);
        System.out.println(name.getNodeValue());
        return name.getNodeValue();
	}
	public String parseFromXml() throws ParserConfigurationException, SAXException, IOException {
		prepareToParse();	
		String temp=null;
		NodeList items = document.getElementsByTagName("pozycja");
        for (int i = 0; i < items.getLength(); i++)
        {
            Node n = items.item(i);
            if (n.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element e = (Element) n;
            //get currency name
            temp+=parseFieldFromXml(e, "nazwa_waluty");
            
            //get currency code
            temp+=parseFieldFromXml(e, "kod_waluty");
            
            //get exchange rate
            temp+=parseFieldFromXml(e, "kurs_sredni");
        }
        return temp;
	}
	public List<Currency> parseCurrenciesFromXml() throws ParserConfigurationException, SAXException, IOException{
		ArrayList<Currency> temp = new ArrayList<Currency>();
		prepareToParse();	
		NodeList items = document.getElementsByTagName("pozycja");
        for (int i = 0; i < items.getLength(); i++)
        {
            Node n = items.item(i);
            if (n.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element e = (Element) n;
            temp.add(new Currency(parseFieldFromXml(e, "nazwa_waluty"),parseFieldFromXml(e, "kod_waluty"),parseFieldFromXml(e, "kurs_sredni")));
        }
		
		return temp;
	}


}
