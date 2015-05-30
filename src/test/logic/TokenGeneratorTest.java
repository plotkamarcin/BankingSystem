package logic;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class TokenGeneratorTest {
	TokenGenerator sut;
@Before
public void init(){
	sut = new TokenGenerator();
}
	@Test
	public void shouldGenerateToken() throws Exception {
		String temp=null;
		temp=sut.generateToken(1);
		assertTrue(temp.length()!=0);
	}
	@Test
	public void shouldGenerateTokenWith4Numbers() throws Exception {
		String temp="";
		temp=sut.generateToken(4);
		assertThat(temp.length(),is(4));
		
	}

}
