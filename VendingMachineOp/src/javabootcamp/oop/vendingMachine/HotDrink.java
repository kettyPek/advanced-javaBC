package javabootcamp.oop.vendingMachine;
/**
 * Describes the properties of a hot drink
 * @author ketty
 *
 */
public abstract class HotDrink extends Drink{
	
	protected int teaSpoonsOfsugar ;

	public HotDrink(int volume, float temprature,int teaSpoonsOfsugar, float price) {
		super(volume,temprature,price);
		setTeaSpoonsOfsugar(teaSpoonsOfsugar);
		checkPrefferedTemp(temprature);
	}
	
	/**
	 * Checks if the given number of sugar teaspoons is in the range [0,5]
	 * if its out of the range a default value of 0 is set
	 * @param teaSpoonsOfsugar - the given number of sugar teaspoons
	 */
	protected void setTeaSpoonsOfsugar(int teaSpoonsOfsugar) {
		if(teaSpoonsOfsugar>=0 && teaSpoonsOfsugar<=5)
			this.teaSpoonsOfsugar = teaSpoonsOfsugar;
		else
			this.teaSpoonsOfsugar = 0;
	}
	
	/**
	 * Checks if the given temperature is in the range of [60,90]
	 * if its out of the range a default value of 60 is set
	 * @param temprature - the given temperature of the drink
	 */
	protected void checkPrefferedTemp(float temprature) {
		if(temprature<60 || temprature>90)
			super.setTempratue(60);
	}
	
}
