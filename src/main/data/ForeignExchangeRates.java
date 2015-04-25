package data;

import java.util.ArrayList;

public class ForeignExchangeRates {
	
	ArrayList<Currency> currencies;
	
	
	public ForeignExchangeRates(){
		currencies=new ArrayList<Currency>();
	}
	public void addCurrency(Currency c){
		currencies.add(c);
	}
	@Override
	public String toString(){
		String temp = null;
		for(Currency c:currencies){
			temp+=c.toString()+"\n";
		}
		return temp;
	}
}
