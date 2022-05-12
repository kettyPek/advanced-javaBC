package ajbc.exam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectsReaderWriter {
	
public static void writeRandomObjectToFile(Object [] objects) throws IOException {
		
		int randomIndex = (int)(Math.random()*4);
		
		try (FileOutputStream fileOutput = new FileOutputStream("examFiles/objectsData.dat");
				ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput)) {

			objOutput.writeObject(objects[randomIndex]);
			System.out.println(objects[randomIndex]);
		}
	}
	
	public static void readObjectsFromFile() throws ClassNotFoundException, IOException {
		System.out.println("printing obects form list:");
		try (FileInputStream fileInput = new FileInputStream("examFiles/objectsData.dat");
				ObjectInputStream objStream = new ObjectInputStream(fileInput);) {
			while(true) {
				try{
					System.out.println(objStream.readObject());
					break;
				}catch(ClassNotFoundException e){
					System.out.println("no more objects");
				}
			}
		}
	}
	
	

	

}
