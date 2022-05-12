package ajbc.check_points;

public class CheckPoint {
	
	protected String name;
	protected String adress;
	protected int positionNumber;
	protected static int checkPoints;
	
	static {
		checkPoints = 0;
	}

	
	public CheckPoint(String name, String adress) {
		this.name = name;
		this.adress = adress;
		positionNumber = checkPoints;
		checkPoints++;
	}


	public String getName() {
		return name;
	}


	public String getAdress() {
		return adress;
	}


	public int getPositionNumber() {
		return positionNumber;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public void setPositionNumber(int positionNumber) {
		this.positionNumber = positionNumber;
	}


	@Override
	public String toString() {
		return "CheckPoint [name=" + name + ", adress=" + adress + ", positionNumber=" + positionNumber + "]";
	}
	
	
	
	

}
