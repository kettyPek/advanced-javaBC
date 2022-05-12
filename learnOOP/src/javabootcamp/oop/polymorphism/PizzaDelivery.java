package javabootcamp.oop.polymorphism;

import java.util.Arrays;

public class PizzaDelivery extends Delivery{
	
	protected String [] description;
	protected float bill;
	
	public PizzaDelivery(String clientName, String clientAdress, String[] description, float bill) {
		super(clientName, clientAdress);
		this.bill = bill;
		this.description = Arrays.copyOf(description,description.length);	
	}

	@Override
	public String toString() {
		String msg = super.toString();
		msg +="\ntotal of " + description.length + " pizzas :\n";
		for(int i=0; i<description.length; i++)
			msg += description[i] + "\n";
		msg += "your total is " + bill;
		return msg;
	}
	
	@Override
	public void deliver() {
		System.out.println(toString());
	}
	
	
	
	
	
	
	

}
