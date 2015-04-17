package logic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class InterestRateCalculatorTest {
	InterestRateCalculator sut;
	double amount;
	double interestRate;
	int months;

	@Before
	public void init() {
		sut = new InterestRateCalculator();
		amount = 1000.0;
		interestRate = 2.1;
		months = 5;
	}

	@Test
	public void shouldCalcualteAnnualInterest() {
		double result = sut.calculateAnnualInterest(interestRate, amount);
		assertEquals(21.0, result, 0.01);
	}

	@Test
	public void shouldCalculateMonthlyInterest() {
		double result = sut.calculateMonthlyInterest(interestRate, amount);
		assertEquals(1.75, result, 0.01);
	}

	@Test
	public void shoudCalculateInterestInPeriod() {
		double result = sut.calcualtePeriodInterest(interestRate, amount, months);
		assertEquals(8.75, result, 0.01);
	}

	@Test
	public void shouldCalculateAnnualTotalBalanceAfterTaxation() {
		double result = sut.calculateAnnualTotalBalanceAfterTaxation(interestRate, amount);
		assertEquals(1017.01,result,0.01);
	}

	@Test
	public void testCalcualteAnnualTotalBalaceBeforeTaxation(){
		double result = sut.calcualteAnnualTotalBalaceWithoutTaxation(interestRate, amount);
		assertEquals(1021.0,result,0.01);
	}
}
