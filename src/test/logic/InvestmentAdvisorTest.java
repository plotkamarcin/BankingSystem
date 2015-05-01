package logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InvestmentAdvisorTest {
	@Mock
	private InterestRateCalculator irc;
	@InjectMocks
	private InvestmentAdvisor investmentAdvisor;

	@Test
	public void testCreateAdvice() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
