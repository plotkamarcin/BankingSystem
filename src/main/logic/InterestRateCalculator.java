package logic;

public class InterestRateCalculator {

	private static double TAX_RATE=0.19;
	
	public InterestRateCalculator(){
		
	}
	
	public double calculateAnnualInterest(double interestRate,double amount){
		return (amount*(interestRate/100));
	}
	public double calculateMonthlyInterest(double interestRate, double amount){
		return (amount*((interestRate/100)/12));
	}
	public double calcualtePeriodInterest(double interestRate, double amount, int months){
		return (amount*((interestRate*months/100)/12));
	}
	public double calculateAnnualTotalBalanceAfterTaxation(double interestRate, double amount){
		return amount + calculateAnnualInterest(interestRate, amount)*(1-TAX_RATE);
	}
	public double calcualteAnnualTotalBalaceWithoutTaxation(double interestRate, double amount){
		return amount + calculateAnnualInterest(interestRate, amount);
	}

	@Override
	public String toString() {
		return "This is the interest rate calculator";
	}
	
}
