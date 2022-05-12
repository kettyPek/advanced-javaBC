package ajbc.builder_ex;

public class Pastry {
	
	protected String pastryName;
	protected int mozzarella;
	protected int feta;
	protected int mashrooms;
	protected int pineapple;
	
	public Pastry(String pastryName,int mozzarella, int feta, int mashrooms, int pineapple) {
		this.pastryName = pastryName;
		this.mozzarella = mozzarella;
		this.feta = feta;
		this.mashrooms = mashrooms;
		this.pineapple = pineapple;
	}
	
	

	public String getName() {
		return pastryName;
	}

}
