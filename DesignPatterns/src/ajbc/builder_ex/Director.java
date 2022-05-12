package ajbc.builder_ex;


public class Director {
	
	private final int HAWAIIN_PIZZA_MOZZARELLA = 100, HAWAIIN_PIZZA_FETA = 40,
			HAWAIIN_PIZZA_MASHROOMS = 20, HAWAIIN_PIZZA_PINEAPPLE = 25;
	
	private final int DOMINICAN_PASTRY_MOZZARELLA = 10 ,DOMINICAN_PASTRY_FETA = 100,
			DOMINICAN_PASTRY_MASHROOMS = 20, DOMINICAN_PASTRY_PINEAPPLE = 15;
			
	public void makeHawaiinPizza(Builder builder) {
		builder.buildPastryType("Hawaiin Pizza");
		builder.addMozzarella(HAWAIIN_PIZZA_MOZZARELLA);
		builder.addFeta(HAWAIIN_PIZZA_FETA);
		builder.addMashrooms(HAWAIIN_PIZZA_MASHROOMS);
		builder.addPineapple(HAWAIIN_PIZZA_PINEAPPLE);
	}
	
	public void makeDominicanPuffPastry(Builder builder) {
		builder.buildPastryType("Dominican-Puff pastry");
		builder.addMozzarella(DOMINICAN_PASTRY_MOZZARELLA);
		builder.addFeta(DOMINICAN_PASTRY_FETA);
		builder.addMashrooms(DOMINICAN_PASTRY_MASHROOMS);
		builder.addPineapple(DOMINICAN_PASTRY_PINEAPPLE);
	}
	
	public void makeHawaiinPizzaRecipe(Builder builder) {
		makeHawaiinPizza(builder);
	}
	
	public void makeDominicanPuffPastryRecipe(Builder builder) {
		makeDominicanPuffPastry(builder);
	}
	
	
}
