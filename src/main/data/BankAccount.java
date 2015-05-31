package data;

public class BankAccount {
	private int id;
	private String type;
	private String accountNumber;
	private double balance;
	
	public BankAccount(int id, String type, String accountNumber, double balance) {
		this.id = id;
		this.type = type;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
