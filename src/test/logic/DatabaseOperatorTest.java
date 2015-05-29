package logic;

import java.sql.*;

import org.junit.Before;
import org.junit.Test;

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
	public void shouldGetAllCustomers() throws SQLException{
		sut.connectToDatabase("Banking.mdb");
		sut.getAllCustomers();
	}
	@Test
	public void shouldGetCustomerNameByLogin() throws SQLException{
		sut.connectToDatabase("Banking.mdb");
		sut.getCustomerInformationByLogin("kowalmaster");
	}

}
