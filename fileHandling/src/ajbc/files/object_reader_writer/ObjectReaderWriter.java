package ajbc.files.object_reader_writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectReaderWriter {
	
	public static void writeSimpleDemo() {
		int num = 10;
		double dNum = 123.45;
		String str = "Hi";
		
		try (FileOutputStream file = new FileOutputStream("myFiles/objFile.dat");
				ObjectOutputStream output = new ObjectOutputStream(file)){
			
			output.writeInt(num);
			output.writeDouble(dNum);
			output.writeObject(str);
			
		}catch(IOException e){
			System.out.println(e);
		}
			
	}
	
	public static void readObjectDemo() {
		try(FileInputStream file = new FileInputStream("myFiles/objectFile1.dat");
				ObjectInputStream input = new ObjectInputStream(file)){
			
		}catch() {
			
		}
	}
	
	

}
