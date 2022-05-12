package javabootcamp.oop.vendingMachine;
/**
 * Describes the properties of Latte
 * @author ketty
 *
 */
public class HotLatte extends Coffe{
	
	private static final int VOLUME = 50;
	private static final float TEMPRATURE = 90f;
	private static final float PRICE = 15f;
	private static final int SUGER = 1;
	private static final int SHOTS = 1;
	
	public HotLatte() {
		super(VOLUME,TEMPRATURE,SUGER,SHOTS,PRICE);
	}
	
	/**
	 * Checks if there is enough milk or water in the vending machine to prepare the drink
	 * and update the quantities, if not - change vending machine status 
	 */
	@Override
	public void produce() {
		if(produceDrink())
			System.out.println("The drink: Latte is ready.");
		else {
			System.out.println("The drink can not be produced.");
			VendingMachine.canProduce = false;
		}
		System.out.println("-------------");
	}



}
