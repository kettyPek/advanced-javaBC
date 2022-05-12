package javabootcamp.oopexam.doll;

import java.time.LocalDate;

import javabootcamp.oopexam.kid.Kid;
import javabootcamp.oopexam.kid.Kid.AgeGroup;
import javabootcamp.oopexam.toy.Toy;
/**
 * Describe doll properties
 * @author ketty
 *
 */
public class Doll extends Toy{
	
	protected DollType dollType;
	protected int dirtiness;
	
	public Doll(Kid kid, String name, LocalDate purchaseDate, DollType dollType) {
		super(name, purchaseDate,kid);
		this.dollType = dollType;
		dirtiness = 0;
	}

	
	
	/**
	 * checks if the kid can play with the toy
	 * increases its dirtiness level if it can be played
	 */
	@Override
	public void play() {
		if(super.isBorken==true) {
			System.out.println("The toy is broken");
			return;
		}
		if(super.kid.getAgeGroup()== AgeGroup.C || super.kid.getAgeGroup()== AgeGroup.D) {
			System.out.println("The kid is not in the right age");
			return;
		}
		if(dirtiness<10)
			dirtiness++;	
		System.out.println("You played with " + toString());
	}

	@Override
	public String toString() {
		return  "a "+ dollType + " doll, its dirtiness level is " + dirtiness;
	}

	public static enum DollType {
		SOFT, HARD;
	}
	
}
