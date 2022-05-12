package javabootcamp.oop.umlFlightEx;

import java.util.Arrays;
/**
 * Describes a frequent flyers credit balance and contains flights history
 * @author ketty
 *
 */
public class Credit {
	
	protected FrequentFlyer frequentFlyer;
	protected Flight[] flights;
	protected int bonus;
	protected int credit = 0;
	
	public Credit(FrequentFlyer frequentFlyer, Flight[] flights, int bonus) {
		this.frequentFlyer = frequentFlyer;
		setFlights(flights);
		setBonus(bonus);
		calculateCredit();
	}
	
	//
	
	private void setFlights(Flight[] flights) {
		this.flights = Arrays.copyOf(flights, flights.length);
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public Flight[] getFlight() {
		return flights;
	}
	
	public FrequentFlyer getFrequentFlyer() {
		return frequentFlyer;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	/**
	 * Adding another flight to the flights array
	 * @param flight - new flight to add
	 */
	public void addFlight(Flight flight) {
		Flight [] tempFlights = new Flight [flights.length+1];
		tempFlights = Arrays.copyOf(flights, flights.length);
		tempFlights[tempFlights.length-1] = flight;
		flights = Arrays.copyOf(tempFlights, tempFlights.length);
	}
	
	/**
	 * Calculates the frequent flyers credit by flights duration and bonus
	 */
	private void calculateCredit() {
		for(Flight flight: flights) 
			credit += flight.getFlightDuration();
		credit += bonus;	
	}
	
}
