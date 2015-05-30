package logic;

public class InterestRateCalculator {

	private static double TAX_RATE=0.19;
	
	public static double STANDARD_INTEREST_RATE=1.50;
	public static double PREMIUM_INTEREST_RATE=1.60;
	public static double INTERNET_INTEREST_RATE=1.80;
	public static double BUSINESS_INTEREST_RATE=1.85;
	
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
