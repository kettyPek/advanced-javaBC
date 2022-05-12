package ajbc.builder_ex;

public class Runner {

	public static void main(String[] args) {

		Director director = new Director();

		PastryBuilder pastryBuilder = new PastryBuilder();
		RecipeBuilder recipeBuilder = new RecipeBuilder();
		Pastry pastry;
		Recipe recipe;

		// Hawaiin Pizza and recipe
		director.makeHawaiinPizza(pastryBuilder);
		pastry = pastryBuilder.getResult();
		System.out.println("Pastry created: " + pastry.getName());

		director.makeHawaiinPizzaRecipe(recipeBuilder);
		recipe = recipeBuilder.getResult();
		System.out.println(recipe);

		// Dominican-Puff pastry and recipe
		director.makeDominicanPuffPastry(pastryBuilder);
		pastry = pastryBuilder.getResult();
		System.out.println("Pastry created: " + pastry.getName());

		director.makeDominicanPuffPastryRecipe(recipeBuilder);
		recipe = recipeBuilder.getResult();
		System.out.println(recipe);
	}

}
