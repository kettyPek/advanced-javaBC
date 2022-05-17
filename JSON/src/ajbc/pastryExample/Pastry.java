package ajbc.pastryExample;

import java.util.List;

public class Pastry {
	
	private String name;
	private int calories;
	private PastryLable lable;
	private List<Ingredient> ingredients;
	

	public Pastry(String name, int calories, PastryLable lable, List<Ingredient> ingredients) {
		this.name = name;
		this.calories = calories;
		this.lable = lable;
		this.ingredients = ingredients;
	}
	
	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public PastryLable getLable() {
		return lable;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	

	@Override
	public String toString() {
		return "Pastry [name=" + name + ", calories=" + calories + ", lable=" + lable + ", ingredients=" + ingredients
				+ "]";
	}



	public enum PastryLable{
		DAIRY,MEAT,PARVE;
	}
}

