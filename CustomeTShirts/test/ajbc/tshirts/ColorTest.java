package ajbc.tshirts;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ajbc.tshirts.Color;

@TestInstance(Lifecycle.PER_METHOD)

class ColorTest {
	private final double [] COLOR1_FIELDS = {2,7,10};
	private final double [] COLOR2_FIELDS = {100,100,300};
	private final double [] COLOR3_FIELDS = {0,0,0};
	private Color [] colors;
	
	public ColorTest() {
		colors = new  Color [3];
		colors[0] = new Color((short)2,(short)7,(short)10);
		colors[1] = new Color((short)100,(short)100,(short)300);
		colors[2] = new Color();
	}

	@Test
	@DisplayName("constractor test")
	void testConstractor() {
		assertNotNull(colors[0]);
		assertNotNull(colors[1]);
		assertNotNull(colors[2]);
	}
	
	@Test
	@DisplayName("equality of all object fields")
	void testEqualityOfFiels() {
		testEqualityForArray(COLOR1_FIELDS,0);
		testEqualityForArray(COLOR2_FIELDS,1);
		testEqualityForArray(COLOR3_FIELDS,2);
	}
	
	void testEqualityForArray(double [] arr, int colorsIndex) {
		assertEquals(arr[0], colors[colorsIndex].getRed());
		assertEquals(arr[1], colors[colorsIndex].getGreen());
		assertEquals(arr[2], colors[colorsIndex].getBlue());
	}
	
	@Test
	@DisplayName("equality of array's dominant colors")
	void testEqualityOfDominantColors() {
		assertEquals("Blue", colors[0].getDiminant());
		assertEquals("Blue", colors[1].getDiminant());
		assertEquals("Blue", colors[2].getDiminant());
	}
	
	@Test
	void testSetRed() {
		colors[0].setRed((short)3);
		assertEquals(3, colors[0].getRed());
	}

	
	

}
