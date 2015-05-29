package logic;

import java.util.Random;

public class TokenGenerator {

	public String generateToken(int howManyNumbers){
		String s="";
		Random r = new Random();
		
		for (int i=0;i<howManyNumbers;i++){
			Integer temp=r.nextInt(10);
			s+=temp.toString();
		}
		return s;
	}
}
