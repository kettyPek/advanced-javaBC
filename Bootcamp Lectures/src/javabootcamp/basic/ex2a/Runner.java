package javabootcamp.basic.ex2a;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Question 1, receives an age from a user and return if he is a minor or a grown up
//		System.out.println("Enter your age:");
//		float age = scanner.nextFloat();
//		if(age<=0) {
//			System.out.println("Invalid age");
//		}
//		else if(age<18) {
//			System.out.println("You are a minor");
//		}
//		else {
//			System.out.println("You are a grown up");
//		}
		
//		//Question 3, checks if the digits of a given number are the same
//		System.out.println("Enter a number:");
//		int num = scanner.nextInt();
//		if(num/10 == num%10) {
//			System.out.println("The digits are the same");
//		}
//		else {
//			System.out.println("The digits are different");
//		}
		
//		//Question 5, checks if the digits of a given number are the subsequent
//		System.out.println("Enter a number:");
//		int num = scanner.nextInt();
//		int firstDig = num/10;
//		int secondDig = num%10;
//		if((secondDig-firstDig)==1 ) {
//			System.out.println("The digits are subsequent");
//		}
//		else {
//			System.out.println("The digits are not subsequent");
//		}
		
		//Question 7, checks if fuel amount is less than 15% of tank capacity
//		float advicedPer =0.15f;
//		System.out.println("Enter the tank capacity:");
//		float capacity = scanner.nextFloat();
//		System.out.println("Enter current fuel quantity:");
//		float currentFuel = scanner.nextFloat();
//		if(currentFuel<=advicedPer*capacity) {
//			System.out.println("You should refuel the car");
//		}
//		else {
//			System.out.println("No need to refuel the car");
//		}
		
		//Question 9, disassemble 8 digit number into a date
		System.out.println("Enter date as 8 digits number:");
		int date = scanner.nextInt();
		int year = date%10000;
		int month = (date/10000)%100;
		int day = date/1000000;
		System.out.printf("The year is %d, the month is %d, the day is %d",year,month,day);
		
		scanner.close();
	}

}
