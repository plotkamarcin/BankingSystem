package logic;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.*;

public class DatabaseOperator {

	public Connection conn;

	public void connectToDatabase(String filename) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String database = "jdbc:ucanaccess://" + filename;
			conn = DriverManager.getConnection(database, "", "");
		} catch (Exception ex) {
			JOptionPane
					.showMessageDialog(
							null,
							"Could not connect to database. Please check your connection or try again later.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	public ArrayList<Customer> getAllCustomers() throws SQLException {
		ArrayList<Customer> temp = new ArrayList<Customer>();
		String sql = "SELECT * FROM Customers";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			int userId = rs1.getInt("Identyfikator");
			String name = rs1.getString("Name");
			String surname = rs1.getString("Surname");
			String city = rs1.getString("City");
			String street = rs1.getString("Street");
			String socialId = rs1.getString("SocialId");
			String yearOfBirth = rs1.getString("YearOfBirth");
			Boolean isActive = rs1.getBoolean("IsActive");
			String email = rs1.getString("Email");
			temp.add(new Customer(userId, name, surname, city, street,
					socialId, yearOfBirth, isActive, email));
		}
		return temp;
	}
	public String getUserEmailAddress(String username) throws SQLException{
		String temp = "";

		String sql = "SELECT * FROM Customers WHERE Login='" + username + "'";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			temp= rs1.getString("Email");
		}
		return temp;
	}

	public String[] getUserLoginCredential(String username) throws SQLException {
		String[] temp = new String[2];

		String sql = "SELECT * FROM Customers WHERE Login='" + username + "'";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			String login = rs1.getString("Login");
			String pass = rs1.getString("Password");
			temp[0] = login;
			temp[1] = pass;
		}
		return temp;
	}

	public ArrayList<BankAccount> getAllAcounts() throws SQLException {
		ArrayList<BankAccount> temp = new ArrayList<BankAccount>();
		String sql = "SELECT * FROM Accounts";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			int accountId = rs1.getInt("Identyfikator");
			String type = rs1.getString("Type");
			String balance = rs1.getString("Balance");
			String accountNumber = rs1.getString("Number");
			temp.add(new BankAccount(accountId, type, accountNumber, Double
					.parseDouble(balance)));
		}
		return temp;
	}

	public ArrayList<Investment> getAllInvestments() throws SQLException {
		ArrayList<Investment> temp = new ArrayList<Investment>();
		String sql = "SELECT * FROM Investments";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			int investmentId = rs1.getInt("Identyfikator");
			String amount = rs1.getString("Amount");
			String interest = rs1.getString("Interest");
			String expires = rs1.getString("Expires");
			temp.add(new Investment(investmentId, Double.parseDouble(amount),
					Double.parseDouble(interest), expires));
		}
		return temp;
	}

	public ArrayList<BankTransfer> getAllTransfers() throws SQLException {
		ArrayList<BankTransfer> temp = new ArrayList<BankTransfer>();
		String sql = "SELECT * FROM Transfers";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			int investmentId = rs1.getInt("Identyfikator");
			String recipent = rs1.getString("Recipent");
			String senderAccountNumber = rs1.getString("SenderAccount");
			String reciepentAccountNumber = rs1.getString("RecipentAccount");
			String amount = rs1.getString("Amount");
			String description = rs1.getString("Description");
			String verificationCode = rs1.getString("TransactionID");
			String date = rs1.getString("Date");
			temp.add(new BankTransfer(recipent, senderAccountNumber,
					reciepentAccountNumber, Double.parseDouble(amount),
					description, verificationCode, date));
		}
		return temp;
	}

}
