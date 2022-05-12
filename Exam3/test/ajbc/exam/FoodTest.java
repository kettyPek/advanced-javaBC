package ajbc.exam;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import ajbc.exam.Food.Macronutrients;
import ajbc.exam.Food.Taste;

class FoodTest {
	
	private Food food;
	public FoodTest() throws NonCapatilizedException {
		food = new Food("Cookie",Taste.SWEET,Macronutrients.CARBO_HYDRATE);
	}

	@Test
	void testIsDesert() {
		assertTrue(food.isDesert());
	}
	
	@Test
	void testNonCaptalizedException() {
		assertThrows(NonCapatilizedException.class,()-> food.setName("cookie"));
		
	}
	
	@Test
	void testSetName() throws NonCapatilizedException {
		food.setName("Pizza");
		assertEquals("Pizza", food.name);
	}
	
	
	

}
