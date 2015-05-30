package data;

public class BankAccount {
	private int id;
	private String type;
	private String accountNumber;
	private double balance;
	
	public BankAccount(int id, String type, String accountNumber, double balance) {
		super();
		this.id = id;
		this.type = type;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
