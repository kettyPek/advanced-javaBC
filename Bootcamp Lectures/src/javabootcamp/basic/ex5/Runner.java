package javabootcamp.basic.ex5;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		//Question 1,
//		int [] firstArr = new int [5];
//		int [] secondArr = new int [5];
//		int arraysLenngth = firstArr.length;
//		String areSame = " ";
//		
//		System.out.println("Enter numbers into the first array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			firstArr[i] = scanner.nextInt();
//		}
//		System.out.println("Enter numbers into the second array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			secondArr[i] = scanner.nextInt();
//			if(secondArr[i]!=firstArr[arraysLenngth-i-1])
//				areSame = " NOT ";
//		}
//		System.out.println("The arrays are"+areSame+"inverted");
		
//		//Question 3,
//		int [] arr = new int [10];
//		System.out.println("Enter 2 numers :");
//		for (int i=0; i<arr.length;i++) {
//			if(i<=1)
//				arr[i]=scanner.nextInt();
//			else {
//				arr[i]= arr[i-2]+arr[i-1];
//			}
//		}
//		for (int i=0; i<arr.length;i++) 
//			System.out.print(arr[i]+" ");
		
//		//Question 5, check if 2 given arrays have the same elements with one shift left
//		int [] firstArr = new int [5];
//		int [] secondArr = new int [5];
//		int arraysLenngth = firstArr.length;
//		String areSame = " ";
//		int j;
//		
//		System.out.println("Enter numbers into the first array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			firstArr[i] = scanner.nextInt();
//		}
//		System.out.println("Enter numbers into the second array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			secondArr[i] = scanner.nextInt();
//		}
//		for(int i=1;i<arraysLenngth;i++) {
//			j = (i+1)%arraysLenngth;
//			if(secondArr[i]!=firstArr[j])
//				areSame = " NOT ";
//		}
//		System.out.println("Array are"+ areSame + "the same");
		
//		//Question 7,creat new array which contains similar elements from 2 given arrays
//		int [] firstArr = new int [5];
//		int [] secondArr = new int [5];
//		int [] thirdArr = new int [5];
//		int arraysLenngth = firstArr.length;
//		int count = 0;
//		
//		System.out.println("Enter numbers into the first array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			firstArr[i] = scanner.nextInt();
//		}
//		System.out.println("Enter numbers into the second array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			secondArr[i] = scanner.nextInt();
//		}
//		for(int i=0;i<arraysLenngth;i++) {
//			for(int j=0;j<arraysLenngth;j++) {
//				if(secondArr[j]==firstArr[i]) {
//					thirdArr[count] = secondArr[j];
//					System.out.print(thirdArr[count]+" ");
//					count++;
//					break;					
//				}
//			}
//		}
//		System.out.println("Third array contains "+count+" elements");
		
//		//Question 9, check if the sum of every elements digits are the same for 2 given arrays
//		int [] firstArr = new int [3];
//		int [] secondArr = new int [3];
//		int arraysLenngth = firstArr.length;
//		String areSame = " ";
//		int firstArrSum = 0 , secondArrSum = 0, firstTemp, secondTemp;
//
//		
//		System.out.println("Enter numbers into the first array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			firstArr[i] = scanner.nextInt();
//		}
//		System.out.println("Enter numbers into the second array:");
//		for(int i=0;i<arraysLenngth;i++) {
//			secondArr[i] = scanner.nextInt();
//		}
//		for(int i=0;i<arraysLenngth;i++) {
//			firstTemp = firstArr[i];
//			secondTemp= secondArr[i];
//			while(true) {
//				if(firstTemp==0 && secondTemp==0)
//					break;
//				firstArrSum += firstTemp%10;
//				secondArrSum += secondTemp%10;
//				firstTemp/=10;
//				secondTemp/=10;	
//			}
//			if(firstArrSum!=secondArrSum) {
//				areSame = " NOT ";
//				break;
//			}
//		}
//		System.out.println("Arrays are"+ areSame + "the same");
		
//		//Question 11, find max value on the perimeter of the matrix - not completed
//		int rows, cols;
//		System.out.println("Enter number of rows:");
//		while(true){
//			rows = scanner.nextInt();
//			if(rows>=1 && rows<=10)
//				break;
//			else 
//				System.out.println("Value should be between 1-10, try again");
//		}
//		while(true){
//			cols = scanner.nextInt();
//			if(cols>=1 && cols<=10)
//				break;
//			else 
//				System.out.println("Value should be between 1-10, try again");
//		}
//		//filling the matrix
//		int [][] arr = new int[rows][cols];
//		int size = rows*cols;
//		System.out.println("Enter "+size+" numbers :" );
//		for(int i=0;i<rows;i++) {
//			for(int j =0; j<cols; j++)
//			{
//				arr[i][j]=scanner.nextInt();
//			}
//		}
//		//finding max value on the perimeter
//		int max = arr[0][0];
//		int r = 0, c = 1;
//		while(r!=0 || c!=0) {
//			if(arr[r][c]>max)
//				max=arr[r][c];
//			if(c==cols-1) 
//				r++;	
//			else
//				c++;
//			if(r==rows-1)
//				c--;
//			if(c==0)
//				r--;
//		}
//		//printing matrix
//		for(int k=0;k<rows;k++) {
//			for(int m =0; m<cols; m++)
//			{
//				System.out.print(arr[k][m]+" ");
//			}
//			System.out.println("");
//		}
//		System.out.println("Max value is "+max);
		
		//Question 15, check if the diagonal values are equal 
		System.out.println("Enter matrix order:");
		int matLength = scanner.nextInt();
		int [][] mat = new int [matLength][matLength];
		String isFolded =" ";
		
		System.out.println("Enter numbers for "+matLength+"x"+matLength+" matrix:");
		for(int i=0;i<matLength;i++) {
			for(int j=0;j<matLength;j++) {
				mat[i][j] = scanner.nextInt();
			}
		}
		
		for(int i=0;i<matLength/2;i++) {
			for(int j=0;j<matLength;j++) {
				if(mat[i][j]!=mat[j][i])
					isFolded = " NOT ";
			}
		}
		
		System.out.println("The matrix is" + isFolded + "folded");
		
		
		scanner.close();

	}

}
