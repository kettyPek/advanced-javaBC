package ajbc.builder_ex;

public class PastryBuilder implements Builder{
	
	protected String pastryName;;
	protected int mozzarella;
	protected int feta;
	protected int mashrooms;
	protected int pineapple;

	@Override
	public void buildPastryType(String type) {
		this.pastryName = type;
		
	}
	
	@Override
	public void addMozzarella(int mozzarella) {
		this.mozzarella = mozzarella;
		
	}

	@Override
	public void addFeta(int feta) {
		this.feta = feta;
		
	}

	@Override
	public void addMashrooms(int mashrooms) {
		this.mashrooms = mashrooms;
		
	}

	@Override
	public void addPineapple(int pineapple) {
		this.pineapple = pineapple;
		
	}
	
	public Pastry getResult() {
		return new Pastry(pastryName,mozzarella,feta,mashrooms,pineapple);
	}
	
	

	
}


