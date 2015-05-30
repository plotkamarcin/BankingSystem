package main;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.*;
import logic.DatabaseOperator;

public class ApplicationData {

	private DatabaseOperator databaseOperator;
	private ArrayList<BankAccount> accounts;
	private ArrayList<BankTransfer>transfers;
	private ArrayList<Customer> customers;
	private ArrayList<Investment> investments;
	
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	public ArrayList<BankTransfer> getTransfers() {
		return transfers;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public ArrayList<Investment> getInvestments() {
		return investments;
	}
	
	ApplicationData(){
		databaseOperator=new DatabaseOperator();
		try {
			loadFromDatabase("Banking.mdb");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Could not load data. Please check your connection or try again later.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void loadFromDatabase(String filename) throws SQLException{
		databaseOperator.connectToDatabase(filename);
		accounts=databaseOperator.getAllAcounts();
		transfers=databaseOperator.getAllTransfers();
		customers=databaseOperator.getAllCustomers();
		investments=databaseOperator.getAllInvestments();
	}
	
}
