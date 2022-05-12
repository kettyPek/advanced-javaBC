package javabootcamp.oop.vendingMachine;
/**
 * Describes the properties of a cold drink
 * @author ketty
 *
 */
public abstract class ColdDrink extends Drink{

	public ColdDrink(int volume, float temprature, float price) {
		super(volume, temprature, price);
		checkPrefferedTemp(temprature);
	}
	
	/**
	 * Checks if the given temperature is in the range of [2,5]
	 * if its out of the range a default value of 2 is set
	 * @param prefferdTemp
	 */
	private void checkPrefferedTemp(float prefferdTemp) {
		if(prefferdTemp<2 || prefferdTemp>5)
			super.setTempratue(2);
	}

}
