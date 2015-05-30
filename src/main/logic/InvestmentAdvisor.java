package logic;

import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;


public class InvestmentAdvisor {

	private InterestRateCalculator interestCalculator;

	public InvestmentAdvisor(InterestRateCalculator irc) {

		this.interestCalculator = irc;
	}

	public String createAdvice(double interest, double balance, int months) {
		ArrayList<Double> amounts = new ArrayList<Double>();
		for (int i = 1; i <= months + 1; i++) {
			Double temp = interestCalculator.calcualtePeriodInterest(interest,
					balance, i);
			amounts.add(temp);
		}
		Double maxAmount = Collections.max(amounts);
		Integer maxIndex = amounts.indexOf(Collections.max(amounts));
		if (balance < 3000.00) {
			return "Can't open investment below " + balance + "!";
		} else
			return "Best option is " + maxIndex + " months, with earnings of "
					+ maxAmount + "\n";
	}

	public Object[][] createValuesTable(double amount) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(6);
		ints.add(12);
		ints.add(24);

		Object[][] temp= new Object[6][6];
		for(Integer i:ints){
			BigDecimal standard = new BigDecimal(interestCalculator.calcualtePeriodInterest(InterestRateCalculator.STANDARD_INTEREST_RATE, amount, i));
			BigDecimal premium= new BigDecimal(interestCalculator.calcualtePeriodInterest(InterestRateCalculator.PREMIUM_INTEREST_RATE, amount, i));
			BigDecimal internet= new BigDecimal(interestCalculator.calcualtePeriodInterest(InterestRateCalculator.INTERNET_INTEREST_RATE, amount, i));
			BigDecimal business= new BigDecimal(interestCalculator.calcualtePeriodInterest(InterestRateCalculator.BUSINESS_INTEREST_RATE, amount, i));
			standard=standard.setScale(2,RoundingMode.HALF_DOWN);
			premium=premium.setScale(2,RoundingMode.HALF_DOWN);
			internet=internet.setScale(2,RoundingMode.HALF_DOWN);
			business=business.setScale(2,RoundingMode.HALF_DOWN);
			temp[ints.indexOf(i)]=new Object[]{i+ " months",standard,premium,internet,business};
		}
		return temp;
	}
	
}
