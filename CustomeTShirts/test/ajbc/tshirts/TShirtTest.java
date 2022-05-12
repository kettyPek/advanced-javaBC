package ajbc.tshirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ajbc.tshirts.Tshirt.Sizes;

class TshirtTest {
	
	private final Sizes SIZE = Sizes.S;
	private final Design DESIGN = new Design();
	private final double DEMAND_FACTOR = 0.5;
	private final double BASE_PRICE = 50;
	private final int EXPENSIVE_PRICE = 10000;
	
	private Tshirt tshirt;
	
	public TshirtTest() {
		tshirt = new Tshirt(SIZE,DESIGN,DEMAND_FACTOR,BASE_PRICE);
	}

	@Test
	void testConstractor() {
		assertEquals(SIZE, tshirt.size);
		assertEquals(DESIGN, tshirt.design);
		assertEquals(DEMAND_FACTOR, tshirt.demandFactor);
		assertEquals(BASE_PRICE,tshirt.basePrice);
	}
	
	@Test 
	void testSetSize() {
		tshirt.setSize(Sizes.L);
		assertEquals(Sizes.L, tshirt.size);
	}
	
	@Test 
	void testSetDesign() {
		Design expectedDesign = new Design();
		tshirt.setDesign(expectedDesign);
		assertEquals(expectedDesign, tshirt.design);
	}
	
	@Test 
	void testDemandFactor() {
		tshirt.setDemandFactor(0.7);
		assertEquals(0.7, tshirt.demandFactor);
	}
	
	@Test 
	void testBasePrise() {
		tshirt.setBasePrise(0.8);
		assertEquals(0.8, tshirt.basePrice);
	}
	
	@Test
	void testCalculateFinalPrice() {
		double expected = (BASE_PRICE + DESIGN.complexity)*DESIGN.calculateArea()/DEMAND_FACTOR;
		assertEquals(expected, tshirt.calculateFinalPrice());
	}
	
	@Test
	void testIsExpensive() {
		boolean expected = (tshirt.calculateFinalPrice()>=EXPENSIVE_PRICE)? true : false;
		assertEquals(expected,tshirt.isExpensive());
	}

}
