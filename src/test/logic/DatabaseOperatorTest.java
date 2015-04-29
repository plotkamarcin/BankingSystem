package logic;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

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

}
