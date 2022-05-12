package javabootcamp.oop.umlFlightEx;
/**
 * Contains information of a frequent flyer
 * @author ketty
 *
 */
public class FrequentFlyer {
	
	protected final long FREQUENT_FLYER_NUMBER;
	protected String firstName;
	protected String lastName;
	private static int counter;
	protected Credit credit;
	
	static {
		counter = 0;
	}
	
	public FrequentFlyer(String firstName, String lastName) {
		FREQUENT_FLYER_NUMBER = counter++;
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	//
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public long getFFlyerNumber() {
		return FREQUENT_FLYER_NUMBER;
	}

	

	

	
	
	
	
	

}
