package javabootcamp.oop.lights;

public class Light {
	//fields
	private int numberOfBulbs;
	private boolean isOn;
	
	//constructors
	public Light() {
		this(3,true);
	}
	
	public Light(int numberOfBulbs, boolean lightState) {
		setNumberOfBulbs(numberOfBulbs);
		setIsOn(lightState);
	}
	
	//methods
	public int getNumberOfBulbs() {
		return numberOfBulbs;
	}
	
	public boolean getIsOn() {
		return isOn;
	}
	
	public void setNumberOfBulbs(int numberOfBulbs) {
		if(numberOfBulbs>0 && numberOfBulbs<=50)
			this.numberOfBulbs = numberOfBulbs;
		else 
			return;
	}
	
	public void setIsOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	//
	public void turnOn() {
		setIsOn(true);
		System.out.println("On");
	}
	
	public void turnOff() {
		setIsOn(false);
		System.out.println("Off");
	}
	
	public void printFields() {
		String state = "Off";
		if(isOn)
			state = "On";
		System.out.println(state);
		System.out.println("Number of bulbs is :"+numberOfBulbs);
			
	}
	
	public void toggle(Light light) {
		light.isOn =!light.isOn;
	}
	
	public void toggle() {
		toggle(this);
	}

	
	

}
