package ajbc.builder_ex;

public class Recipe {
	
	protected String pastryName;
	protected int mozzarella;
	protected int feta;
	protected int mashrooms;
	protected int pineapple;
	
	
	public Recipe(String type,int mozzarella, int feta, int mashrooms, int pineapple) {
		this.pastryName = type;
		this.mozzarella = mozzarella;
		this.feta = feta;
		this.mashrooms = mashrooms;
		this.pineapple = pineapple;
	}
	
	
	@Override
	public String toString() {
		return "Recipe [name=" + pastryName + ", mozzarella=" + mozzarella + ", feta=" + feta + ", mashrooms=" + mashrooms
				+ ", pineapple=" + pineapple + "]";
	}
	

}
