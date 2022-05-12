package javabootcamp.oop.lights;

public class Runner {

	public static void main(String[] args) {
		
		Light light1 = new Light();
		Light light2 = new Light(2,false);
		
		System.out.println("light1:");
		light1.printFields();
		System.out.println("light2:");
		light2.printFields();
		
		light1.turnOff();
		light2.setNumberOfBulbs(10);
		System.out.println("light1:");
		light1.printFields();
		System.out.println("light2:");
		light2.printFields();
		
		light1.turnOn();
		light2.turnOn();
		
		light1.turnOff();
		light2.turnOff();
		
		

	}

}
