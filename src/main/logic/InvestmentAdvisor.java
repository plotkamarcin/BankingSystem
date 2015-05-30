package logic;

import java.util.ArrayList;
import java.util.Collections;

public class InvestmentAdvisor {

	private InterestRateCalculator interestCalculator;
	public InvestmentAdvisor(InterestRateCalculator irc) {
		
		this.interestCalculator = irc;
	}

	public String createAdvice(double interest,double balance,int months) {
		ArrayList<Double> amounts=new ArrayList<Double>();
		for(int i=1;i<=months+1;i++){
			Double temp=interestCalculator.calcualtePeriodInterest(interest, balance, i);
			amounts.add(temp);
		}
		Double maxAmount = Collections.max(amounts);
		Integer maxIndex = amounts.indexOf(Collections.max(amounts));
		if(balance<3000.00){
			return "Can't open investment below "+balance+"!";
		}
		else
		return "Best option is "+maxIndex+" months, with earnings of "+maxAmount+"\n";
	}

}
