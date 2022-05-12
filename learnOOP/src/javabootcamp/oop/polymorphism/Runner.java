package javabootcamp.oop.polymorphism;

public class Runner {

	public static void main(String[] args) {
		
		ParcelDelivery delivery1 = new ParcelDelivery("ketty","haifa",2,true);
		delivery1.deliver();
		String [] details = {"pizza with cheese"};
		PizzaDelivery  pizzaDelivery1 = new PizzaDelivery("ketty","haifa",details, 100);
		pizzaDelivery1.deliver();
	}

}
