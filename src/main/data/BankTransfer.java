package data;

import java.util.Date;

public class BankTransfer {

	private String recipent;
	private String senderAccountNumber;
	private String reciepentAccountNumber;
	private double amount;
	private String description;
	private String verificationCode;
	private String date;
	
	
	public String getRecipent() {
		return recipent;
	}

	public void setRecipent(String recipent) {
		this.recipent = recipent;
	}

	public String getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(String senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	public String getReciepentAccountNumber() {
		return reciepentAccountNumber;
	}

	public void setReciepentAccountNumber(String reciepentAccountNumber) {
		this.reciepentAccountNumber = reciepentAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public BankTransfer(String recipent, String senderAccountNumber,
			String reciepentAccountNumber, double amount, String description,
			String verificationCode, String date) {
		super();
		this.recipent = recipent;
		this.senderAccountNumber = senderAccountNumber;
		this.reciepentAccountNumber = reciepentAccountNumber;
		this.amount = amount;
		this.description = description;
		this.verificationCode = verificationCode;
		this.date = date;
	}
 
}
