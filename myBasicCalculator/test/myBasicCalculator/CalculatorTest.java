package myBasicCalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import myBasicCalculator.Calculator.Operation;

@DisplayName("calculator class tests")
class CalculatorTest {
	
	private final int CONSTTACTOR1 = 2; 
	private Calculator calculator1;

	
	public CalculatorTest() {
		calculator1 = new Calculator(2);
	}

	@Test
	@DisplayName("constractor.answer should be "+ CONSTTACTOR1)
	void checkConstractor() {
		int actual = calculator1.answer;
		int expected = CONSTTACTOR1;;
		assertEquals(expected, actual);
	}
	
	@Test
	void checkSum() {
		calculator1.sum(3, 5);
		assertEquals(8, calculator1.answer);
		assertTrue(calculator1.lastOperation==Operation.ADD);
	}
	
	@Test
	void checkOperation() {
		assertNull(calculator1.lastOperation);
	}
	
	@Test
	void checkArray() {
		int [] arr1 = {1,2,3};
		int [] arr2 = {1,2,3};
		assertArrayEquals(arr1, arr2);
	}
	
	
	@Test
	void checkDivide() {
		assertThrows(ArithmeticException.class,()->calculator1.divide(20, 0));
	}
	
	

}
