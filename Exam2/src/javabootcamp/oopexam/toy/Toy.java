package javabootcamp.oopexam.toy;

import java.time.LocalDate;
import java.time.Period;

import javabootcamp.oopexam.kid.Kid;
/**
 * Describes Toy details 
 * @author ketty
 *
 */
public abstract class Toy {
	
	protected String name;
	protected final LocalDate PURCHASE_DATE;
	protected final long SERIAL_NUMBER;
	protected boolean isBorken;
	protected static int counter;
	protected Kid kid;
	
	static {
		counter = 0;
	}
	
	public Toy(String name, LocalDate purchaseDate,Kid kid) {
		this.kid = kid;
		this.name = name;
		this.PURCHASE_DATE = purchaseDate;
		SERIAL_NUMBER = counter++;
		isBorken = false;
		checkIfBroken();
	}

	//
	public String getName() {
		return name;
	}

	public LocalDate getPurchaseDate() {
		return PURCHASE_DATE;
	}

	public boolean getIsBorken() {
		return isBorken;
	}

	public long getSERIAL_NUMBER() {
		return SERIAL_NUMBER;
	}
	
	public abstract void play();
	
	/**
	 * checks if the toy is more then 10 years old
	 */
	private void checkIfBroken() {
		LocalDate today = LocalDate.now();
		Period p = Period.between(today, PURCHASE_DATE);
		if(p.getYears()>10)
			isBorken = true;
	}
	
	
	
	

}
