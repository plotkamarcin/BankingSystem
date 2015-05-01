package logic;

import org.junit.Before;
import org.junit.Test;

public class BankPdfGeneratorTest {

	private BankPdfGenerator sut;
	@Before
	public void init(){
		sut = new BankPdfGenerator();
	}
	
	@Test
	public void shouldGenerateBankPdfFile() throws Exception {
		sut.generateBankPdf();
	}

	@Test
	public void testGenerateBankPdfWithContent() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
