package javabootcamp.basic.loops;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Check if a number is prime 
//		System.out.println("Enter number:");
//		int num = scanner.nextInt();
//		String isPrime = "prime";
//		
//		for(int i=1; i<num; i++)
//		{
//			if(num%i == 0) {
//				isPrime = "NOT prime"; 
//			}
//		}
//		System.out.println("The number " + num+ " is "+ isPrime);
		
		//Build a number from received digits
//		System.out.println("Enter number:");
//		int num = 0, digit=0;
//		do {
//			num = num*10+digit;
//			digit = scanner.nextInt();
//		}while (digit>=0);
//		System.out.println(num);
		
		//Calculating the product of given number until receiving negative number	
//		System.out.println("Enter number:");
//		int num = scanner.nextInt();
//		int prod = (num<=0) ? 0 : 1;
//		
//		while (num>=0 && prod!=0) {			
//			prod*=num;
//			if(num!=0) {
//				num = scanner.nextInt();
//			}
//		}
//		System.out.println("The product is : "+ prod);
		
		//
		int fixedCount=0, rejectCount = 0, shipCount = 0;
		int temp;
		int amount = scanner.nextInt();
		for(int i=1;i<=amount;i++) {
			temp = scanner.nextInt();
			if(temp==1) {
				fixedCount++;
			}
			else if(temp==-1) {
				rejectCount++;
			}
			else {
				shipCount++;
			}
		}
		System.out.println(shipCount+" "+fixedCount+" "+rejectCount);
			
		
		
		scanner.close();
		
	}

}
