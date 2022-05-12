package javaboocanp.basic.conditions;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//check if user input divided by 2,3,4
		
//		final int divider = 12;
//		
//		System.out.println("Please enter an Integer:");
//		int num = scanner.nextInt();
//		String result = (num%divider==0) ? " " : " NOT ";
//		
//		System.out.println(num + " is" + result + "dividable");
//		System.out.println("Goodbye");
		
		//checks if the first number is in the range between the second and the third number
		
//		String state = "";
//		int start, end;
//		
//		System.out.println("Enter first number:");
//		int first = scanner.nextInt();
//		System.out.println("Enter second number:");
//		start = scanner.nextInt();
//		System.out.println("Enter third number:");
//		end = scanner.nextInt();
//		
//		//swap if the range is opposite
//		if(end < start ) {
//			int temp = start;
//			start = end;
//			end = temp;
//		}
//
//		if(first < start) {
//			state = "smaller than";
//		}
//		else if(first > end) {
//			state = "bigger than";
//		}
//		else {
//			state = "in";
//		}
//		System.out.println(first + " is " + state + " the range " + small + " to "+ big);
		
		//Month name by number & days
		String month = "";
		int days = 31;
		
		System.out.println("Enter a year:");
		int year = scanner.nextInt();
		
		if(year<0) {
			System.out.println("Invalide year value");
		}
		else {
			System.out.println("Enter a month number:");
			int monthNum = scanner.nextInt();
			if(monthNum>12 || monthNum<1) {
				System.out.println("Invalide month value");
			}
			else {
				switch(monthNum) {
				
				case 1:
					month = "January";
					break;
				case 2 :
					month = "February";
					days = ((year-2020)%4==0) ? 29 : 28;
					break;
				case 3 :
					month = "March";
					break;
				case 4 :
					month = "April";
					days = 30;
					break;
				case 5:
					month = "May";
					break;
				case 6:
					month = "June";
					days = 30;
					break;
				case 7:
					month = "July";
					break;
				case 8:
					month = "August";
					break;
				case 9:
					month = "September";
					days = 30;
					break;
				case 10:
					month = "October";
					break;
				case 11:
					month = "Novemver";
					days = 30;
					break;
				case 12:
					month = "December";
					break;
					}
				System.out.println(month+" has "+days+" days");
			}
		}

		scanner.close();
	}
}
