package javabootcamp.oop.vendingMachine;
/*
 * Describes the properties of soft drink
 */
public abstract class SoftDrink extends ColdDrink{
	
	protected boolean isSqueezed;
	
	public SoftDrink(int volume, float temprature, float price, boolean isSqeezed) {
		super(volume,temprature, price);
		this.isSqueezed = isSqeezed;
	}
	
	@Override
	public String toString() {
		String msg = " squeezed ";
		if (isSqueezed)
			msg = " pazteurized ";
		return msg;
	}
}
