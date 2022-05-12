package ajbc.files.scanner_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReaderDemo {

	public static void readerDemo() {

		File file = new File("myFiles/output3.txt");


		try (Scanner sc = new Scanner(file)) {

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				int num = sc.nextInt();
				float fNum = sc.nextFloat();
				System.out.println("String is: "+line);
				System.out.println("num is: "+num);
				System.out.println("float is: "+fNum);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
		System.out.println(e);
	}

	}}
