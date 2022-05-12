package javabootcamp.oop.exercise;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public abstract class HomeAppliance implements Appliable {
	
	protected String manufacturer ;
	protected int purchaseYear;
	protected  int powerConsumption;
	
	//
	public HomeAppliance (String manufacturer , int purchaseYear, int powerConsumption){
		setManufacturer(manufacturer);
		setPurchaseYear(purchaseYear);
		setPowerConsumption(powerConsumption);
		
	}
	//
	public void setPowerConsumption(int powerConsumption) {
		 this.powerConsumption = powerConsumption;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		if(manufacturer!=null)
			this.manufacturer = manufacturer.toUpperCase();
	}
	
	public int getPurchaseYear() {
		return purchaseYear;
	}
	
	public void setPurchaseYear(int purchaseYear) {
		Calendar dNow = Calendar.getInstance();
		int curretYear = dNow.get(Calendar.YEAR);
		if(purchaseYear>1900 && purchaseYear<curretYear)
			this.purchaseYear = purchaseYear;
		else
			this.purchaseYear = curretYear;
	}
	
	@Override
	public String toString() {
		return "HomeAppliance [manufacturer=" + manufacturer + ", purchaseYear=" + purchaseYear + ", powerConsumption="
				+ powerConsumption + "]";
	}
	public void display() {
		System.out.println(this);
	}
	
	public abstract int totalPowerConsumption(int workingHours);
	
	@Override
	public LocalTime turnOn() {
		System.out.println("Turned on");
		return LocalTime.now();
	}
	
	@Override
	public long turnOffSec(LocalTime on) {
		System.out.println("Turned off");
		LocalTime now = LocalTime.now();
		return  now.until(on,ChronoUnit.SECONDS);
	}
	
	

}
