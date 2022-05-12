package ajbc.exeptions.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Runner {

	public static void readFile(String path) throws FileNotFoundException {
		FileReader file = new FileReader(path);
	}
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

//		String path = "src/mytext.txt";
//		Scanner sc = new Scanner(System.in);
//		sc.next();
//		try {
//			readFile(path);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			System.out.println("This is the end.");
//			
//		}
//		sc.close();
//		System.out.println("scanner is closed.");

		System.out.println("Enter a num: ");
		int num1 = 100;
		int num2 = getInt("Enter number");
		int res = 0;
		while (true) {
			try {
				res = num1 / num2;
				break;
			} catch (ArithmeticException e) {
				System.out.println("Integer cannot be 0");
				num2 = getInt("Enter number");			
			}
		}
		System.out.println("result is : " + res);
		sc.close();
	}

	private static int getInt(String string) {
		String numInput ;
		float num = 1;
		while(true) {
			try {
				numInput = sc.next();
				num = Float.parseFloat(numInput);
				break;
			} catch (NumberFormatException e) {
				System.out.println("input not an Integer or a Float");
			}
		}
		return (int)num;
		
	}
	
}
