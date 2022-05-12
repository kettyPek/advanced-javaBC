package javabootcamp.oopexam.electricToy;

import java.time.LocalDate;

import javabootcamp.oopexam.kid.Kid;
import javabootcamp.oopexam.kid.Kid.AgeGroup;
import javabootcamp.oopexam.toy.Toy;
/**
 * Describe electric toy properties 
 * @author ketty
 *
 */
public class ElectricToy extends Toy{
	
	protected final int BATERRIES_NUMBER;
	protected int sound;
	
	
	public ElectricToy(Kid kid, String name,LocalDate purchaseDate, int batteriesNum) {
		super(name, purchaseDate,kid);
		BATERRIES_NUMBER = batteriesNum;
		sound = 3;
	}

	/**
	 * checks if the kid can play with the toy
	 * decreases its sound level if it can be played
	 */
	@Override
	public void play() {
		if(super.isBorken==true) {
			System.out.println("The toy is broken");
			return;
		}
		if(super.kid.getAgeGroup()== AgeGroup.D) {
			System.out.println("The kid is not in the right age");
			return;
		}
		if(sound>0)
			sound--;	
		System.out.println("You played with " + toString());
		
	}

	@Override
	public String toString() {
		return "an electric toy, with current sound level of " + sound;
	}
	
	

}
