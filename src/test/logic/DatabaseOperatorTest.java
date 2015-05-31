package logic;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.sql.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.*;

public class DatabaseOperatorTest {
	DatabaseOperator sut;

	@Before
	public void init(){
		sut = new DatabaseOperator();
	}
	@Test
	public void shouldConnectToDatabase() throws Exception {
		sut.connectToDatabase("Banking.mdb");
	}
	@Test
	public void shouldFindUsernameLoginCredentials() throws SQLException{
		String[] temp= new String[2];
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getUserLoginCredential("kowalmaster");
		assertThat(temp[0],is("kowalmaster"));
		assertThat(temp[1],is("12345QwertY"));
	}
	@Test
	public void shouldCreateTableWithCustomers() throws SQLException{
		ArrayList<Customer> temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllCustomers();
		assertThat(temp.size(),is(not(0)));
	}
	@Test
	public void shouldGetUserEmailAddress() throws SQLException{
		String temp="";
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getUserEmailAddress("kowalmaster");
		assertThat(temp,is("igor.avz@gmail.com"));
	}
	@Test
	public void shouldGetTableWithAllCustomers() throws SQLException{
		ArrayList<Customer> temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllCustomers();
		assertThat(temp.size(),is(1));
	}
	@Test
	public void shouldHaveJanKowalskiAsFirstCustomer() throws SQLException{
		ArrayList<Customer> temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllCustomers();
		assertThat(temp.get(0).getName(),is("Jan"));
		assertThat(temp.get(0).getSurname(),is("Kowalski"));
	}
	@Test
	public void shouldGetAllAccounts() throws SQLException{
		ArrayList<BankAccount>temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllAcounts();
		assertThat(temp.size(),is(not(0)));
		assertThat(temp.size(),is(2));
	}
	@Test
	public void shouldGetCorrectAccountBalanceAndTypeValues() throws SQLException{
		ArrayList<BankAccount>temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllAcounts();
		assertThat(temp.get(0).getAccountNumber(),is("234"));
		assertThat(temp.get(0).getBalance(),is(100.00));
		assertThat(temp.get(1).getAccountNumber(),is("556"));
		assertThat(temp.get(1).getBalance(),is(3000.00));
	}

	@Test
	public void shouldGetAllInvestments() throws SQLException{
		ArrayList<Investment>temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllInvestments();
		assertThat(temp.size(),is(not(0)));
		assertThat(temp.size(),is(1));
	}
	@Test
	public void shouldHave40000AtOneAndHalfPercent() throws SQLException{
		ArrayList<Investment>temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllInvestments();
		assertThat(temp.get(0).getAmount(),is(40000.00));
		assertThat(temp.get(0).getInterest(),is(1.5));
	}
	@Test
	public void shouldGetAllTransfers() throws SQLException{
		ArrayList<BankTransfer>temp;
		sut.connectToDatabase("Banking.mdb");
		temp=sut.getAllTransfers();
		assertThat(temp.size(),is(not(0)));
		assertThat(temp.size(),is(2));
	}
}
