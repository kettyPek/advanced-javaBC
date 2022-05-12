package javabootcamp.oop.vendingMachine;
/**
 * Describe the properties of apple juice
 * @author ketty
 *
 */
public class AppleJuice extends SoftDrink{

	private static final int VOLUME = 200;
	private static final float TEMPRATURE = 3f;
	private static final float PRICE = 10f;
	private static final boolean SQUEEZED = false;

	public AppleJuice() {
		super(VOLUME,TEMPRATURE,PRICE,SQUEEZED);
	}
	
	/**
	 * Checks if there is enough water in the vending machine to produce the drink
	 * and update the quantities, if not - change vending machine status 
	 */
	@Override
	public void produce() {
		if(VendingMachine.waterQtt>=VOLUME) {
			System.out.println("The drink:"+ super.toString()+"apple juice is ready.");
			VendingMachine.waterQtt -= VOLUME;
		}
		else {
			System.out.println("The drink can not be produced.");
			VendingMachine.canProduce = false;
		}
		System.out.println("-------------");
	}

}
