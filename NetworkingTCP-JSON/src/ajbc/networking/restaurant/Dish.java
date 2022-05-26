package ajbc.networking.restaurant;

public class Dish {
	
	private String name;
	private float price;
	
	public Dish(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + "]";
	}
}
