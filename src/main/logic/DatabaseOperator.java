package logic;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseOperator {

	public void connectToDatabase(String filename){
	        try
	        {
	        	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            String database = 
	                      "jdbc:ucanaccess://"+filename;
	            Connection conn = DriverManager.getConnection(database, "", "");
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        }
	    
	}
	
}
