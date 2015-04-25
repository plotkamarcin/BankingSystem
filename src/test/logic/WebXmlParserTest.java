package logic;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import org.hamcrest.collection.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hamcrest.core.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import data.Currency;

public class WebXmlParserTest {

	public WebXmlParser sut;
	public List<Currency> sut2;
	
	@Before
	public void init(){
		sut=new WebXmlParser();
	} 
	
	@Test
	public void shouldParseFromXml() throws Exception {
		String test = sut.parseFromXml();
		assertThat(test,not(isEmptyOrNullString()));
	}
	
	@Test
	public void shouldContain35Elements() throws ParserConfigurationException, SAXException, IOException{
	sut2=sut.parseCurrenciesFromXml();
	assertThat(sut2.size(),is(35));
}
	@Test
	public void shouldCreateArrayOfCurrenciesFromXml() throws ParserConfigurationException, SAXException, IOException{
		
		sut2=sut.parseCurrenciesFromXml();
		assertTrue(sut2.size()>0);
	}
	@Test
	public void shouldHaveTHBCurrencyItemsInTheArray() throws ParserConfigurationException, SAXException, IOException{
			
		sut2=sut.parseCurrenciesFromXml();
		assertThat(sut2.get(0).getCode(),is("THB"));
		assertThat(sut2.get(0).getExchangeRate(),is("0,1134"));
		assertThat(sut2.get(0).getName(),is("bat (Tajlandia)"));
	}
	@Test
	public void shouldHaveUSDCurrencyItemsInTheArray() throws ParserConfigurationException, SAXException, IOException{
		
		sut2=sut.parseCurrenciesFromXml();
		assertThat(sut2.get(1).getCode(),is("USD"));
		assertThat(sut2.get(1).getExchangeRate(),is("3,6895"));
		assertThat(sut2.get(1).getName(),is("dolar amerykañski"));
	}
	@Test
	public void shouldHaveXDRCurrencyItemsInTheArray() throws ParserConfigurationException, SAXException, IOException{
		
		sut2=sut.parseCurrenciesFromXml();
		assertThat(sut2.get(sut2.size()-1).getCode(),is("XDR"));
		assertThat(sut2.get(sut2.size()-1).getExchangeRate(),is("5,1515"));
		assertThat(sut2.get(sut2.size()-1).getName(),is("SDR (MFW)"));
	}

}
