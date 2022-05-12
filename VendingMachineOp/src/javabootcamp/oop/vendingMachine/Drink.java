package javabootcamp.oop.vendingMachine;
/**
 * Describes a drinks properties 
 * @author ketty
 *
 */
public abstract class Drink implements Produceable{
	
	protected int volume;
	protected float temprature;
	protected float price;
	
	public Drink(int volume, float temprature, float price) {
		setVolume(volume);
		setTempratue(temprature);
		this.price = price;
	}
	
	/**
	 * Set the volume of a drink
	 * The volume can be between 50 to 200 , default value is 50 
	 * @param volume - the volume to set
	 */
	protected void setVolume(int volume) {
		if(volume>=50 && volume<=200)
			this.volume = volume;
		else
			volume = 50;
	}
	
	/**
	 * Set the temperature of the drink
	 * @param temprature - the temperature to set
	 */
	protected void setTempratue(float temprature) {
		this.temprature = temprature;
	}
	
	
	public static enum DrinkBase {
		MILK, WATTER;
	}

}
