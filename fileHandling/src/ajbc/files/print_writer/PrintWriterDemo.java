package ajbc.files.print_writer;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {

	
	public static void writeDemo() {
		String data = "this is the data i want to write";
		int age = 33;
		float money = 1223.5f;
		
		try (PrintWriter printer = new PrintWriter("myFiles/output3.txt")){
			printer.printf( "%s\n%d\n%f",data,age,money);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
