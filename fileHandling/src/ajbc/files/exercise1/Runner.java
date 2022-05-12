package ajbc.files.exercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		File file = new File("myFiles/alice_in_wonderland.txt");
		int wordsCounter = 0;
		int linesCounter = 0;
		String [] wordsInLIne;
		
		try(Scanner sc = new Scanner(file)) {
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				wordsInLIne = line.split(" ");
				linesCounter++;
				if(linesCounter==18)
					System.out.println("18th line is: "+line);
				for(String word: wordsInLIne) {
					wordsCounter++;
					if(wordsCounter==578)
						System.out.println("The 578th word is: "+ word);
				}		
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("There is "+wordsCounter+" words and "+linesCounter+" lines in the text");
	}

}
