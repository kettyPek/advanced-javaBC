package ajbc.networking.restaurant;

import java.util.List;

public class Order {
	
	private static long counter;
	private final long ORDER_ID;
	private List<Dish> dishes;
	
	static {
		counter = 0;
	}

	public Order(List<Dish> dishes) {
		ORDER_ID = counter++;
		this.dishes = dishes;
	}

	@Override
	public String toString() {
		return "Order [ORDER_ID=" + ORDER_ID + ", dishes=" + dishes + "]";
	}

	public List<Dish> getDishes() {
		return dishes;
	}
	
}
