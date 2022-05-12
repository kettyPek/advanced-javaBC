package javabootcamp.basic.ex4;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Question 2, 
//		System.out.println("Enter number:");
//		int num = scanner.nextInt();
//		int firstIn = 0, secondIn =0, count=0, multSec=1, multFirs=1;;
//		while(true) {
//			if(num == 0)
//				break;
//			if(count%2 == 0) {
//				firstIn = firstIn +(num%10)*multFirs;
//				multFirs*=10;
//			}
//			else {
//				secondIn= secondIn +(num%10)*multSec;
//				multSec*=10;
//			}
//			num/=10;
//			count++;
//		}
//		if(count%2!=0)
//			System.out.println(firstIn);
//		else
//			System.out.println(secondIn);
		
		//Question 4, ID 
//		System.out.println("Enter ID number :");
//		int idNum = scanner.nextInt();
//		int sum = 0;
//		int temp = idNum/10;
//		int weight = 0 ;
//		
//		for (int i=1; i<=8; i++) {
//			weight = (temp%10)*(i%2+1);
//			if(weight>9)
//				sum+= weight%10 + weight/10;
//			else
//				sum+= weight;
//			temp/=10;
//		}
//		if((sum/10+1)*10 - sum == idNum%10)
//			System.out.println("ID number correct");
//		else
//			System.out.println("ID number incorrect");
		
		//Question 6, make polindrom from a given number
//		System.out.println("Enter number:");
//		int num = scanner.nextInt();
//		int poli = num;
//		while(true) {
//			if(num==0)
//				break;
//			poli = poli*10 + num%10;
//			num/=10;
//		}
//		System.out.println(poli);
		
		//Question 8,
//		int count = 0;
//		int upperDig, lowerDig;
//		for(int i=10;i<=99;i++) {
//			upperDig = i/10;
//			for(int j=10;j<=99;j++) {
//				lowerDig = j%10;
//				if((float)i/j == (float)upperDig/lowerDig && i<j) {
//					System.out.println(i+" / "+j);
//					count++;
//				}		 
//			}
//		}
//		System.out.println(count);
		
//		//Question 10 - not completed
//		System.out.println("Enter a number:");
//		int num = scanner.nextInt();
//		System.out.println("Enter a digit:");
//		int divider = scanner.nextInt();
//		
//		int newNum = 0, dividedNum = 0, cycle=0;
//		int advancDividedNum = 1, advancNewdNum = 1;
//		
//		while(num!=0) {
//			for(int i=1;i<=divider && num!=0;i++) {
//				dividedNum = dividedNum*advancDividedNum + num%10;
//				num/=10;
//				advancDividedNum*=10;
//				advancNewdNum*=10;
//			}
//			advancDividedNum=1;
//			cycle++;
//			if(cycle == 1)
//				advancNewdNum =1;
//			newNum = newNum + dividedNum*advancNewdNum;
//			dividedNum = 0;
//		}
//		
//		System.out.println("new number: "+newNum);
		
//		//Question 12, Draw triangle by given number
//		System.out.println("Enter number:");
//		int num = scanner.nextInt();
//		
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<num-i; j++) {
//				System.out.print("* ");
//			}
//			System.out.println("");
//			for(int k=0; k<=i; k++) {
//				System.out.print(" ");
//			}
//		}
		
//		//Question 14, Draw squares by given size
//		System.out.println("Enter number");
//		int size = scanner.nextInt();
//		
//		for(int m=0; m<size; m++) {
//			for(int k=0; k<size; k++) {
//				for(int i=0; i<size; i++) {
//					for(int j=0; j<size; j++) {
//						System.out.print("*");
//					}
//					System.out.print(" ");	
//				}
//				System.out.println("");
//			}
//			System.out.println("");
//		}
		
		//Question 16, not completed
		int sum1 = 0, sum2 = 0, count = 0;
		int num1 =220;
		while(count<=10) {
			for(int i=1; i<num1; i++) {
				if(num1%i==0)
					sum1+=i;	
			}
			for(int i=1; i<sum1; i++) {
				if(sum1%i==0)
					sum2+=i;	
			}
			if(sum2==num1) {
				count++;
				System.out.println(num1+ " and "+sum1+" are mates");
			}
			num1++;
		}

		scanner.close();


	}

}
