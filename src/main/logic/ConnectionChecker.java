package logic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ConnectionChecker {

	public String checkConnection(String url) throws UnknownHostException, IOException{
		 HttpURLConnection connection = null;
		 int code=0;
		    try {
		        URL u = new URL(url);
		        connection = (HttpURLConnection) u.openConnection();
		        connection.setRequestMethod("HEAD");
		        code = connection.getResponseCode();
		        // You can determine on HTTP return code received. 200 is success.
		    } catch (MalformedURLException e) {
		        // TODO Auto-generated catch block
		        
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        
		    } finally {
		        if (connection != null) {
		            connection.disconnect();
		        }
		    }
	        if(code==200){
	        	return "CONNECTED TO INTERNET";
	        }
	        else 
	        	{
	        	JOptionPane.showMessageDialog(null, "Could not connect to bank server. Please check your connection or try again later.", "ERROR", JOptionPane.ERROR_MESSAGE);
	        	return  "CONNECTION ERROR "+code;
	        	}
	}
}
