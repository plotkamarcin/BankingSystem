package logic;

import org.junit.*;

public class WebXmlParserTest {
	
	public WebXmlParser sut;
	
	@Before
	public void init(){
		sut=new WebXmlParser();
	}

	@Test
	public void shouldPrintValuesFromXml() throws Exception {
		sut.parseFromXml();
	}
	

}
