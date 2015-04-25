package logic;

import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

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
	
	public void parseFromXml() throws ParserConfigurationException, SAXException, IOException {
		prepareToParse();	
		NodeList items = document.getElementsByTagName("pozycja");
        for (int i = 0; i < items.getLength(); i++)
        {
            Node n = items.item(i);
            if (n.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element e = (Element) n;
            //get currency name
            NodeList nameList = e.getElementsByTagName("nazwa_waluty");
            Element nameElement = (Element) nameList.item(0);
            Node nameNode = nameElement.getChildNodes().item(0);
            System.out.println(nameNode.getNodeValue());
            
            //get currency code
            NodeList currencyCodeList = e.getElementsByTagName("kod_waluty");
            Element currencyCodeElement = (Element) currencyCodeList.item(0);
            Node currencyCodeNode = currencyCodeElement.getChildNodes().item(0);
            System.out.println(currencyCodeNode.getNodeValue());
            
            //get exchange rate
            NodeList exchangeRateList = e.getElementsByTagName("kurs_sredni");
            Element exchangeRateElement = (Element) exchangeRateList.item(0);
            Node exchangeRateNode = exchangeRateElement.getChildNodes().item(0);
            System.out.println(exchangeRateNode.getNodeValue());
        }
	}
}
