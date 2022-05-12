package javabootcamp.oop.polymorphism;

public class ParcelDelivery extends Delivery{
	protected int numOfItems;
	protected boolean isDoorSide;
	
	public ParcelDelivery(String clientName, String clientAdress,int numOfItems, boolean isDoorSide) {
		super(clientName,clientAdress);
		this.numOfItems = numOfItems;
		this.isDoorSide = isDoorSide;
	}

	@Override
	public String toString() {
		String msg = super.toString();
		msg += "\nTotal of items: " + numOfItems;
		if(isDoorSide)
			msg +="\ni left it by the door";
		else
			msg += "\nplease come to sign the delivery.";
		return msg;
	}
	
	@Override
	public void deliver() {
		System.out.println(toString());
	}
	
	
	
	

}
