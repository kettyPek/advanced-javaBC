package ajbc.files.stream_reader_writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class StreamReaderWriter {
	
	public static void readerDemo() {
		char [] array = new char [100];
		
		try(FileInputStream file = new FileInputStream("myFiles/input.txt");
			InputStreamReader input = new InputStreamReader(file,Charset.forName("UTF8"))) {
			
			 // asccii suitable
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
		try (FileOutputStream file = new FileOutputStream("myFiles/output.txt");
				OutputStreamWriter output = new OutputStreamWriter(file)){
			
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
