package ajbc.pastryExample;

public class Ingredient {
	
	private String name;
	private float weight;
	
	public Ingredient(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public float getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", weight=" + weight + "]";
	}
	
	
	
	

}
