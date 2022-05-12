package javabootcamp.oop.vendingMachine;
/**
 * This class describes the current quantity of milk and water in a vending machine 
 * @author ketty
 * 
 */
public class VendingMachine {
	
	public static int milkQtt;
	public static int waterQtt;
	public static boolean  canProduce;
	protected  Drink drink;
	
	static {
		milkQtt = 1000;
		waterQtt = 2000;
		canProduce = true;
	}
	
	/**
	 * Return if the vending machine can produce more drinks
	 * @return true if drinks can be produced, false otherwise
	 */
	public static boolean getCanProduce() {
		return canProduce;
	}
	


}
