package ajbc.tshirts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class DesignTest {
	private final double WIDTH = 20;
	private final double HWIGHT = 10;
	private final String SLOGAN = "";
	private final Color COLOR = new Color();
	private final double COMPLEXITY = 1;
	
	private Design design;
	
	public DesignTest() {
		design = new Design();
	}
	
	
	@Test
	void testConstractor() {
		assertEquals(WIDTH, design.width);
		assertEquals(HWIGHT, design.height);
		assertEquals(SLOGAN, design.slogan);
		assertEquals(COLOR, design.color);
		assertEquals(COMPLEXITY, design.complexity);
	}
	
	@Test
	void TestCalculateArea() {
		double expectedValue = WIDTH*HWIGHT;
		assertEquals(expectedValue, design.calculateArea());
	}
	
	@Test
	void testSetWidth() {
		design.setWidth(25);
		assertEquals(25,design.width);
	}
	
	@Test
	void testSetHiwght() {
		design.setHeight(25);
		assertEquals(25,design.height);
	}

	@Test
	void testSetComplexity() {
		design.setComplexity(80);
		assertEquals(80,design.complexity);
	}
	
	@Test
	void testSetColor() {
		Color expectedColor = new Color((short)5,(short)10,(short)20);
		design.setColor(expectedColor);
		assertEquals(expectedColor,design.color);
	}
	
	@Test
	void testSetSlogan() {
		design.setSlogan("hey");
		assertEquals("hey", design.slogan);
	}
	
	
}
