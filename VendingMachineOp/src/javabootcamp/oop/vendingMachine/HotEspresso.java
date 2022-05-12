package javabootcamp.oop.vendingMachine;
/**
 * Describes the properties of espresso
 * @author ketty
 *
 */
public class HotEspresso extends Coffe{
	
	private static final int VOLUME = 100;
	private static final float TEMPRATURE = 90f;
	private static final float PRICE = 15f;
	private static final int SUGER = 1;
	private static final int SHOTS = 3;
	
	public HotEspresso() {
		super(VOLUME,TEMPRATURE,SUGER,SHOTS,PRICE);
	}
	
	/**
	 * Checks if there is enough milk or water in the vending machine to prepare the drink
	 * and update the quantities, if not - change vending machine status 
	 */
	@Override
	public void produce() {
		if(VendingMachine.waterQtt>=SHOTS*VOLUME) {
			VendingMachine.waterQtt -= SHOTS*VOLUME;
			System.out.println("The drink : Espresso is ready.");
		}
		else {
			System.out.println("The drink can not be produced.");
			VendingMachine.canProduce = false;
		}
		
		System.out.println("-------------");
	}
	
	

}
