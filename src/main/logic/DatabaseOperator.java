package logic;

import java.sql.*;

public class DatabaseOperator {

	public Connection conn;

	public void connectToDatabase(String filename) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String database = "jdbc:ucanaccess://" + filename;
			conn = DriverManager.getConnection(database, "", "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void getAllCustomers() throws SQLException {
		String sql = "SELECT * FROM Customers";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			String userid = rs1.getString("Name");
			String surname = rs1.getString("Surname");

			System.out.println("userid : " + userid);
			System.out.println("username : " + surname);
		}
	}

	public void getCustomerInformationByLogin(String username)
			throws SQLException {
		String sql = "SELECT * FROM Customers WHERE Login='" + username + "'";
		Statement s1 = conn.createStatement();

		ResultSet rs1 = s1.executeQuery(sql);
		while (rs1.next()) {
			String userid = rs1.getString("Name");
			String surname = rs1.getString("Surname");

			System.out.println("userid : " + userid);
			System.out.println("username : " + surname);
		}

	}
}
