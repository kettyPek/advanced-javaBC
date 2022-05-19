package ajbc.json;

public class Room {
	
	private float width;
	private float length;
	private boolean hasAC;
	
	public Room(float width, float length, boolean hasAC) {
		this.width = width;
		this.length = length;
		this.hasAC = hasAC;
	}

	@Override
	public String toString() {
		return "Room [width=" + width + ", length=" + length + ", hasAC=" + hasAC + "]";
	}

}
