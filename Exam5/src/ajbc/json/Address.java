package ajbc.json;

public class Address {
	
	private String street;
	private int number;
	private String state;
	private String city;
	
	public Address(String street, int number, String state, String city) {
		this.street = street;
		this.number = number;
		this.state = state;
		this.city = city;
	}

	
	@Override
	public String toString() {
		return "Adress [street=" + street + ", number=" + number + ", state=" + state + ", city=" + city + "]";
	}
	


}
