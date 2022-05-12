package ajbc.files.buffer_reader_writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class BufferReaderWriter {
	
	public static void readerDemo() {
		char [] array = new char [10000];
		
		try(FileReader file = new FileReader("myFiles/input.txt");
			BufferedReader input = new BufferedReader(file)) {
				
			System.out.println("is the data avaliable in the stream ?" + input.ready());
			input.read(array);
			System.out.println(array);
	
		}catch (FileNotFoundException e) {
				System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void writeDemo() {
		String data = "this is the data i want to write\n";
		String data1 = "added data1\n";
		try (FileWriter file = new FileWriter("myFiles/output2.txt");
				BufferedWriter output = new BufferedWriter(file)){
			
			output.write(data);
			output.append(data1);
			System.out.println("seccess");
			
		}catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	

}
