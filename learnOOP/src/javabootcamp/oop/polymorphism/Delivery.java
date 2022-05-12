package javabootcamp.oop.polymorphism;

public abstract class Delivery {
	protected String clientName;
	protected String clientAdress;
	protected final long ID;
	private static int counter = 0;
	
	
	public Delivery(String clientName, String clientAdress) {
		this.clientName = clientName;
		this.clientAdress = clientAdress;
		this.ID = counter++;
	}

	@Override
	public String toString() {
		return "Delivery number #" + ID + " for " + clientName + " at " + clientAdress ;
	}
	
	public abstract void deliver();


}
