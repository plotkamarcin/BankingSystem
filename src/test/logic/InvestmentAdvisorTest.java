package logic;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InvestmentAdvisorTest {
	private InvestmentAdvisor sut;
	private InterestRateCalculator irc;
	@Before
	public void init(){
		irc = new InterestRateCalculator();
		sut = new InvestmentAdvisor(irc);
	}

	@Test
	public void shouldSayAmountIsTooSmallToOpenInvestment(){
		String temp="";
		temp = sut.createAdvice(4.5, 100.0, 24);
		assertThat(temp,containsString("below 100.0"));
	}
	@Test
	public void shouldSuggest12Months(){
		String temp="";
		temp = sut.createAdvice(4.5, 10000.0, 12);
		assertThat(temp,containsString("12 months"));
	}
	@Test
	public void shouldCreateValidJtableContent(){
		Object [][] temp;
		temp=sut.createValuesTable(6000.0);	
		for(int i=0;i<6;i++){
			assertThat(temp[i][0].toString(),containsString("months"));
		}
	}
	@Test 
	public void shouldCreateValidSizeTable(){
		Object [][] temp;
		temp=sut.createValuesTable(6000.0);	
		assertThat(temp.length,is(6));
	}
}
