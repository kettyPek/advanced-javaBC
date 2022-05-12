package javabootcamp.oop.exercise;

import java.util.Calendar;

import javabootcamp.oop.remoteControl.RemoteControl;

public class Television extends HomeAppliance implements Flatable, Smartable{

	protected float size;
	protected String model;
	protected RemoteControl remoteControl;

	// constructors
	public Television(String manufacturer, int purchaseYear, float size, String transmitMethod, int powerConsumption) {
		super(manufacturer, purchaseYear,powerConsumption);
		setSize(size);
		setModel("S12");
		remoteControl = new RemoteControl(transmitMethod);
	}

	public Television(float size) {
		this("GENERIC", Calendar.getInstance().get(Calendar.YEAR), size,"RF",1000);
	}

	public Television() {
		this(40);
	}

	// methods
	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		if (size < 2.5f || size > 120f)
			this.size = 10;
		this.size = size;
	}

	private String getModel() {
		return model;
	}

	public void setModel(String model) {
		if (model.length() < 3)
			return;
		char ch = model.charAt(0);
		if (Character.isLetter(ch))
			model = 'A' + model;
		char ch1 = model.charAt(1);
		char ch2 = model.charAt(2);
		if (!Character.isLetter(ch1) || !Character.isLetter(ch2))
			model = ch + "00";
		model = model.substring(0, 3);
		this.model = model;

	}
	

	@Override
	public String toString() {
		return "Television [size=" + size + ", model=" + model + ", remoteControl=" + remoteControl + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public void display() {
		System.out.println(this);
	}

	public float sizeInCM() {
		return size * 2.54f;
	}

	public int isBigger(Television other) {
		float diff = this.size - other.size;
		if (diff > 0)
			return 1;
		else if (diff < 0)
			return -1;
		return 0;
	}
	
	@Override
	public int totalPowerConsumption(int workingHours) {
		return this.powerConsumption*workingHours;
	}
	
	@Override
	public boolean isFlat() {
		if(this.purchaseYear<2000)
			return false;
		return true;
	}
	
	@Override
	public boolean isSmart() {
		if(this.purchaseYear<2010)
			return false;
		return true;
	}

}
