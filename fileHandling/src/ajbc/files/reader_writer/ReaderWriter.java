package ajbc.files.reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriter {
	
	public static void readerDemo() {
		char [] array = new char [100];
		
		try {
			Reader input = new FileReader("myFiles/input.txt");
			System.out.println("is the data avaliable in the stream ?" + input.ready());//when we will work with threads we will have to use it
			input.read(array); // reads char char to the array
			input.close();
			System.out.println(array);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void writeDemo() {
		String data = "this is the data i want to write\n";
		String data1 = "added data1\n";
		try {
			Writer output = new FileWriter("myFiles/output.txt");
			output.write(data);
			output.write('9');
			output.append(data1);
			output.close(); // must be closed
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
