package javabootcamp.oop.vendingMachine;

/**
 * Describes the properties of hot chocolate
 * @author ketty
 *
 */
public class HotChocolate extends HotDrink{
	
	private final DrinkBase drinkBase = DrinkBase.MILK;
	private static final int VOLUME = 100;
	private static final float TEMPRATURE = 70f;
	private static final float PRICE = 10f;
	private static final int SUGER = 0;
	
	public HotChocolate() {
		super(VOLUME,TEMPRATURE,SUGER,PRICE);
	}

	/**
	 * Checks if there is enough milk or water in the vending machine to prepare the drink
	 * and update the quantities, if not - change vending machine status 
	 */
	@Override
	public void produce() {
		if(drinkBase == DrinkBase.MILK && VendingMachine.milkQtt>=super.volume) {
			VendingMachine.milkQtt -= super.volume;
			System.out.println("The drink : Hot chocolate is ready");
		}
		else if(drinkBase == DrinkBase.WATTER && VendingMachine.waterQtt>=super.volume) {
			VendingMachine.waterQtt -= super.volume;
			System.out.println("The drink : Hot chocolate is ready");
		}
		else {
			System.out.println("The drink can not be produced");
			VendingMachine.canProduce = false;
		}	
	}
		

}
