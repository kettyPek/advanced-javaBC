package ajbc.exam;

public class Tent {
	
	private int numPeople;
	private double width;
	private double length;
	private double height;
	
	public Tent(int numPeople, double width, double length, double height) {
		this.numPeople = numPeople;
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public int getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tent [numPeople=" + numPeople + ", width=" + width + ", length=" + length + ", height=" + height + "]";
	}
	
	
	
	

}
