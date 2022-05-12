package javabootcamp.basic.ex3;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Question 3, Wedding gift 
		System.out.println("Enter your relationship with the couple : close frined -1 , famaliy member - 2, else - 3");
		int relationship = scanner.nextInt();
		System.out.println("How many years have you known each other?");
		int years = scanner.nextInt();
		System.out.println("How many hours did it take you to arrive");
		int travelTime = scanner.nextInt();
		int gift=0;
		
		switch(relationship) {
		case 1:
			gift = 500;
			break;
		case 2:
			gift = 1000;
			break;
		case 3:
			gift = 250;
			break;
		}
		
		if(relationship!=2 && years >=3)
			gift+=50;
		if(relationship!=2 && travelTime>1)
			gift-=50;
		System.out.println("You should pay "+gift+" for the wedding");
		
		//Question 7, final grade calculator
		System.out.println("Enter Exem grade:");
		int exam = scanner.nextInt();
		System.out.println("Enter HW average grade: ");
		int hw = scanner.nextInt();
		System.out.println("Enter number of submitted HW:");
		int submitted = scanner.nextInt();
		float hwWeight = 0;
		
		switch(submitted) {
		case 5:
		case 6:
			if (exam>=55) {
				hwWeight = 0.2f;
				break;
			}
		case 7:
		case 8:
			if(exam<=54 && hw>=exam)
				hwWeight = 0.25f;
			else if(hw>=exam)
				hwWeight = 0.2f;
		default:
			exam =0;
		}
		float newGrade = exam*(1-hwWeight)+hw*hwWeight;	
		System.out.println("Final grade is: "+newGrade);
		
		scanner.close();

	}

}
