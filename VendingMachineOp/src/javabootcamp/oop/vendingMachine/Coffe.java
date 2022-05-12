package javabootcamp.oop.vendingMachine;
/**
 * Describes the properties of a hot drink that consist coffee
 * @author ketty
 *
 */
public abstract class Coffe extends HotDrink{
	
	protected int numEspressoShots;
	
	public Coffe(int volume, float temprature, int teaSpoonsOfsugar, int numEspressoShots, float price) {
		super(volume, temprature, teaSpoonsOfsugar, price);
		this.numEspressoShots = numEspressoShots;
	}
	
	/**
	 * Checks if there is enough milk or water in the vending machine to prepare the drink and return true 
	 * and update the quantities, otherwise return false
	 * @return true if there is enough milk or water to produce the drink, otherwise false
	 */
	public boolean produceDrink() {
		int neddedWater = super.volume*numEspressoShots;
		int neddedMilk = 200 - neddedWater;
		if(neddedWater<=VendingMachine.waterQtt && neddedMilk<=VendingMachine.milkQtt) {
			VendingMachine.milkQtt -= neddedMilk;
			VendingMachine.waterQtt -= neddedWater;
			return true;
		}
		return false;
	}

}
