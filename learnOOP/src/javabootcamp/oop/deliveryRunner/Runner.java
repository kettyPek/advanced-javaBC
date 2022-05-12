package javabootcamp.oop.deliveryRunner;

import javabootcamp.oop.polymorphism.PizzaDelivery;

import java.util.Random;

import javabootcamp.oop.polymorphism.ParcelDelivery;

public class Runner {

	public static void main(String[] args) {
		System.out.println("Sitting in my home office, I suddenly heard the doorbell.\n"
				+ "I wonder who might it be ?");

	PizzaDelivery pizza = new PizzaDelivery("Ketty Pekarsky","Haifa",new String[]{"a tomato and mushrom"},120);  
	ParcelDelivery parcel = new ParcelDelivery("Ketty Pekarsky","Haifa",2,true);

	Random rand = new Random();
	int opt = rand.nextInt();

	if (opt%2 == 0) {
	System.out.println("Great it's the pizza guy!");
	pizza.deliver();
	}else {
	parcel.deliver();
	System.out.println("Oh I totally forgot I'd ordered this!");
	}
	System.out.println("Great, thanks a lot");

	}

}
