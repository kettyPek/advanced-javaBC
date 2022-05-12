package javabootcamp.oop.vendingMachine;
/**
 * Describes the properties of Cola
 * @author ketty
 *
 */
public class Cola extends Soda{

	private static final int VOLUME = 100;
	private static final float TEMPRATURE = 5f;
	private static final float PRICE = 10f;
	private static final boolean BOTTLE = false;

	public Cola() {
		super(VOLUME,TEMPRATURE,PRICE,BOTTLE);
	}
	
	
	/**
	 * Checks if there is enough water in the vending machine to produce the drink
	 * and update the quantities, if not - change vending machine status 
	 */
	@Override
	public void produce() {
		if(VendingMachine.waterQtt>=VOLUME) {
			System.out.println("You bought Cola "+ super.toString());
			VendingMachine.waterQtt -= VOLUME;
		}
		else {
			System.out.println("The drink can not be produced.");
			VendingMachine.canProduce = false;
		}
		System.out.println("-------------");
	}

}
