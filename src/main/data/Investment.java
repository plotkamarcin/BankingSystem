package data;

public class Investment {

	private int id;
	private double amount;
	private double interest;
	private String expires;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public Investment(int id, double amount, double interest, String expires) {
		this.id = id;
		this.amount = amount;
		this.interest = interest;
		this.expires = expires;
	}
	
	
}
