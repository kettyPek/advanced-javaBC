package ajbc.json;

import java.util.List;

public class House {
	
	private Address address;
	private List<Room> rooms;
	private boolean hasYard;
	private boolean hasBasement;
	private double area;
	
	public House(Address adress, List<Room> rooms, boolean hasYard, boolean hasBasement, double area) {
		this.address = adress;
		this.rooms = rooms;
		this.hasYard = hasYard;
		this.hasBasement = hasBasement;
		this.area = area;
	}

	@Override
	public String toString() {
		return "House [adress=" + address + ", rooms=" + rooms + ", hasYard=" + hasYard + ", hasBasement=" + hasBasement
				+ ", area=" + area + "]";
	}
	
}
