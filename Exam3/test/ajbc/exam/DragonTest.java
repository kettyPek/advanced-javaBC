package ajbc.exam;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DragonTest {
	
	private Dragon dragon;
	
	public DragonTest() {
		
		dragon = new Dragon("drago",LocalDate.of(1996,5, 2),2);
	}

	@Test
	void testTooYoungException() {
		assertThrows(TooYoungException.class,()-> dragon.setBirthDate(LocalDate.of(66, 5, 4)));
		
	}

}
