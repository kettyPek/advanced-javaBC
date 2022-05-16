package ajbc.mvc_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentStatusView {
	
	Scanner scanner = new Scanner(System.in);
	
	
	public String receiveFirstName() {
		System.out.println("Enter first name");
		return scanner.nextLine();
	}
	
	public String receiveLastName() {
		System.out.println("Enter last name");
		return scanner.nextLine();
	}
	
	public long receiveID() {
		System.out.println("Enter ID number");
		return scanner.nextLong();
	}
	
	public List<Double> receiveGrades(){
		ArrayList<Double>grades = new ArrayList<Double>();
		double grade;
		System.out.println("Please enter grades, press any letter to finish.");
		while(true) {
			try{
				grade = scanner.nextDouble();
				grades.add(grade);
			}catch(Exception e) {
				break;
			}
		}
		return grades;
	}
	
	public void displayStatus(String answer) {
		System.out.println("You are " + answer);
		
	}

}
