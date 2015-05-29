package data;

public class Currency {
	private String name;
	private String code;
	private String exchangeRate;

	public Currency(String name, String code, String exchangeRate) {
		this.name = name;
		this.code = code;
		this.exchangeRate = exchangeRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return name + " " + code + " " + exchangeRate +"\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Currency guest = (Currency) obj;
		return ((guest.code == this.code)
				&& (guest.exchangeRate == this.exchangeRate) && (guest.name == this.name));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * code.hashCode();
		result = result * prime * name.hashCode();
		result = result * prime * exchangeRate.hashCode();
		return result;
	}

}
