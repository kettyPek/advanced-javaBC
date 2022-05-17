package ajbc.basicOperations;

public class LicencePlate {
	
	private final long PLATE_NUMBER;
	private String color;
	
	public LicencePlate(long plateNumber, String color) {
		PLATE_NUMBER = plateNumber;
		this.color = color;
	}

	public long getPLATE_NUMBER() {
		return PLATE_NUMBER;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "LicencePlate [PLATE_NUMBER=" + PLATE_NUMBER + ", color=" + color + "]";
	}
	

}
