package javabootcamp.oop.umlFlightEx;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
/**
 * Contains the flight details
 * @author ketty
 *
 */
public class Flight {
	protected final long FLIGHT_NUMBER;
	protected LocalDate departureDate;
	protected LocalTime departureTime;
	protected LocalTime actualDepartureTime;
	protected int flightDuration;
	
	public Flight(long flightNumber,LocalDate departureDate,LocalTime departureTime, int flightDuration) {
		setDepartureDate(departureDate);
		setDepartureTime(departureTime);
		setFlightDuration(flightDuration); 
		this.FLIGHT_NUMBER = flightNumber;
	}
	
	//
	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}
	
	private void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
		actualDepartureTime = departureTime;
	}
	
	private void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	public long getFlightDuration() {
		return flightDuration;
	}
	
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public long getFlightNumer() {
		return FLIGHT_NUMBER;
	}
	
	
	//
	/**
	 * Changes the current departure time to the new departure time
	 * @param departureTime - new departure time
	 */
	public void updateDepartureTime(LocalTime departureTime) {
		actualDepartureTime = departureTime;
	}

}
