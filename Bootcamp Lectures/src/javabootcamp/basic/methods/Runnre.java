package javabootcamp.basic.methods;

import java.util.Scanner;
import java.lang.Math;

public class Runnre {

	// Print name and age
	public static void nameAndAge() {
		System.out.println("name: ketty , age: 26");
	}

	// Receive 3 grades as integers and prints the average
	public static void prineGradeAvg(int grade1, int grade2, int grade3) {
		float average = (grade1 + grade2 + grade3) / 3f;
		System.out.printf("The average is %.2f", average);
	}

	// Receive 3 integers and return the max value
	public static int getMax(int num1, int num2, int num3) {
		int max = num1;
		if (num2 > max)
			max = num2;
		if (num3 > max)
			max = num3;
		return max;
	}

	// Receive 2 integers and return the max value
	public static int getMax(int num1, int num2) {
		int max = num1;
		if (num2 > max)
			max = num2;
		return max;
	}

	// Receive length and returns randomised array
	public static int[] makeRandomArray(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++)
			arr[i] = (int) (Math.random() * 201 - 100);
		return arr;
	}

	// Prints given array
	public static void arrayPrint(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	/**
	 * Receives 2 integer arrays, returns the sum of them in new array
	 * 
	 * @param longArr  must be the longer the shortArr
	 * @param shortArr
	 * @return
	 */
	public static int[] sumOf2Arrays(int[] longArr, int[] shortArr) {
		if (shortArr.length < shortArr.length)
			System.exit(1);

		int[] newArr = longArr;

		for (int i = 0; i < shortArr.length; i++) {
			newArr[i] += shortArr[i];
		}
		return longArr;
	}

	// Receives 2 integer arrays, changes the bigger array to be the sum of them
	public static void changeBiggerArrToSum(int[] arr1, int[] arr2) {
		if (arr1.length > arr2.length)
			arr1 = sumOf2Arrays(arr1, arr2);
		else
			arr2 = sumOf2Arrays(arr2, arr1);
	}
	
	//
	public static int [] concatArr(int[] arr1, int[] arr2) {
		int [] concatArray = new int [arr1.length+arr2.length];
		for (int i=0;i<arr1.length; i++) 
			concatArray[i] = arr1[i];
		for (int i=0;i<arr2.length; i++) 
			concatArray[i+arr1.length] = arr1[i];	
		return concatArray;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

//		nameAndAge();
//		prineGradeAvg(92,94,97);
//		int maxNum3 = getMax(2, 5, 9);
//		int maxNum2 = getMax(2,5);
//		System.out.println("Max value fo 3 numbers: "+maxNum3);
//		System.out.println("Max value fo 2 numbers: "+maxNum2);

//		double ans1 = 10*Math.sin(Math.PI/4);
//		System.out.printf("ans1 = %.2f \n",ans1);
//		double ans2 = 120*Math.PI/180;
//		System.out.printf("120 in rad is = %.2f \n", ans2);
//		double ans3 = Math.exp(2.5);
//		System.out.printf("exp(2.5) = %.2f \n", ans3);

//		int [] arr = makeRandomArray(5);
//		arrayPrint(arr);

		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 5, 6, 7 };
//		changeBiggerArrToSum(arr1, arr2);
//		arrayPrint(arr1);
//		arrayPrint(arr2);
		int [] arr3 = concatArr(arr1,arr2);
		arrayPrint(arr3);

		scanner.close();

	}

}
