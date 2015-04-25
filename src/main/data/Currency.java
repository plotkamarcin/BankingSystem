package data;

public class Currency {
	private String name;
	private String code;
	private String exchangeRate;
	
	public Currency(String name,String code,String exchangeRate){
		this.name=name;
		this.code=code;
		this.exchangeRate=exchangeRate;
	}

	@Override
	public String toString() {
      return name+" "+code+" "+exchangeRate;
	}

}
