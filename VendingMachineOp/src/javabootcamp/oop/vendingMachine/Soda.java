package javabootcamp.oop.vendingMachine;
/**
 * Describes the properties of soda drink
 * @author ketty
 *
 */
public abstract class Soda extends ColdDrink{
	
	protected boolean isBottle;

	public Soda(int volume, float temprature, float price,boolean isBottle) {
		super(volume,temprature,price);
		this.isBottle = isBottle;
	}

	@Override
	public String toString() {
		String msg = " in a can.";
		if (isBottle)
			msg = " in a bottle.";
		return msg;
	}

}
