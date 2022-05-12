package ajbc.exam;

import java.io.IOException;
import java.time.LocalDate;

import ajbc.exam.Food.Macronutrients;
import ajbc.exam.Food.Taste;

public class Runner {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NonCapatilizedException  {
		
		Object [] objects = new Object [4];
		
		objects[0] = new Food("Pizza",Taste.SOUR, Macronutrients.FAT);
		objects[1] = new Food("Cookie",Taste.SWEET, Macronutrients.PROTEIN);
		
		objects[2] = new Dragon("dracarius", LocalDate.of(2002,10,5),2);
		objects[3] = new Dragon("drago", LocalDate.of(1996,7,5),8);
		
		ObjectsReaderWriter.writeRandomObjectToFile(objects);
		ObjectsReaderWriter.writeRandomObjectToFile(objects);
		ObjectsReaderWriter.readObjectsFromFile();
		

	}
	
	
	
}
