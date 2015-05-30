package data;

public class Customer {
	
	private int id;
	private String name;
	private String surname;
	private String city;
	private String street;
	private String socialId;
	private String yearOfBirth;
	boolean isActive=false;
	private String email;
	
    public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	

	
	public Customer(int id, String name, String surname, String city,
			String street, String socialId, String yearOfBirth, boolean isActive,String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.street = street;
		this.socialId = socialId;
		this.yearOfBirth = yearOfBirth;
		this.isActive = isActive;
		this.email=email;
	}

}
