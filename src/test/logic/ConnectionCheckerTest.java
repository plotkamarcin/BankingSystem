package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ConnectionCheckerTest {
	ConnectionChecker sut;
@Before
public void init(){
	sut = new ConnectionChecker();
}
	@Test
	public void shouldConnectToExistingAddress() throws Exception {
		String response="";
		response = sut.checkConnection("http://google.com");
		assertThat(response, is("CONNECTED TO INTERNET"));
	}
	@Test
	public void shouldNotConnectToWrongAddress() throws Exception {
		String response="";
		response = sut.checkConnection("http://www.adaedcakbhdjsda.fj");
		assertThat(response, containsString("CONNECTION ERROR "));
	}

}
