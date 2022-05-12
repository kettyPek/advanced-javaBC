package javabootcamp.basic.ex6;

import java.util.Scanner;

public class Runner {

	// Question 1
	// Receives integer and returns new integer with every digit increased by 1
	public static int increaseByOne(int num) {
		int newNum = 0;
		int shiftLeft = 1;

		while (num != 0) {
			newNum += (num % 10 + 1) % 10 * shiftLeft;
			shiftLeft *= 10;
			num /= 10;
		}
		return newNum;
	}

	// Question 2
	// Receives 2 integers return -1 if they don't have the same length,
	// else return new integer which every digit is the minimum digit of the
	// integers
	public static int returnMinComination(int num1, int num2) {
		int newNum = 0;
		int shiftLeft = 1;
		int minDigit;

		while (true) {
			if (num1 == 0 && num2 == 0)
				break;
			if (num1 == 0 && num2 != 0) {
				newNum = -1;
				break;
			}
			if (num1 % 10 < num2 % 10)
				minDigit = num1 % 10;
			else
				minDigit = num2 % 10;
			newNum += minDigit * shiftLeft;
			shiftLeft *= 10;
			num1 /= 10;
			num2 /= 10;
		}
		return newNum;
	}

	// Question 3
	// Receives an integer and returns if its a perfect number
	public static boolean intIsPerfect(int num) {
		boolean isPerfect = true;
		int sum = 0;

		for (int i = 1; i < num; i++) {
			if (num % i == 0)
				sum += i;
		}

		if (sum != num)
			isPerfect = false;
		return isPerfect;
	}

	// Question 4a
	// Receives an integer and returns the sum of the digits
	public static int digitsSum(int num) {
		int sum = 0;

		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}

	// Question 4b
	// Receives an array and array's length, returns number of elements who's digits
	// sum equal to 10
	public static int digitsSumEqual10(int[] arr, int arrLength) {
		int count = 0;
		int elementSum;

		for (int i = 0; i < arrLength; i++) {
			elementSum = digitsSum(arr[i]);
			if (elementSum == 10)
				count++;
		}
		return count;
	}

	// Question 5
	// Receives number and char, prints rhombus frame built from char
	public static void rhombusFrame(int num, char form) {
		for (int i = 0; i < num - 1; i++) {
			for (int j = 0; j < num * 2; j++) {
				if (num - i - j > 0)
					System.out.print(form);
				if (num + i >= j && num - i <= j)
					System.out.print("-");
				if (j >= num + i)
					System.out.print(form);
			}
			System.out.println("");
		}
		for (int i = num - 1; i >= 0; i--) {
			for (int j = 0; j < num * 2; j++) {
				if (j < num - i)
					System.out.print(form);
				if (num + i >= j && num - i <= j)
					System.out.print("-");
				if (j >= num + i)
					System.out.print(form);
			}
			System.out.println("");
		}
	}

	// Question 6
	// Receives matrix, returns TRUE if a row sum equals to same col sum, else
	// returns FALSE
	public static boolean rowAndColSumIsEqual(int[][] mat) {
		boolean isEqual = true;
		int rowSum = 0, colSum = 0;
		int matLength = mat.length;

		for (int i = 0; i < matLength; i++) {
			for (int j = 0; j < matLength; j++) {
				colSum += mat[i][j];
				rowSum += mat[j][i];
			}
			if (colSum != rowSum) {
				isEqual = false;
				break;
			}
		}
		return isEqual;
	}

	// Question 7
	// Receives matrix and dimension, returns TRUE if the matrix is mirrored, else
	// return False
	public static boolean isMirror(int[][] mat, int rows, int cols) {
		boolean matIsMirror = true;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] != mat[i][cols - j - 1]) {
					matIsMirror = false;
					break;
				}
			}
		}
		return matIsMirror;
	}

	// Question 8
	// Receives 2 arrays that represents integers and return the sum o the arrays in
	// new array
	public static int[] arraysSum(int[] arr1, int[] arr2) {
		int[] longArr = arr1;
		int[] shortArr = arr2;
		int lengthlong = arr1.length;
		int lengthshort = arr2.length;
		int sum = 0, leftDigit = 0;

		if (lengthlong < lengthshort) {
			shortArr = arr1;
			longArr = arr2;
			lengthshort = arr1.length;
			lengthlong = arr2.length;
		}
		int lengthArr3 = lengthlong + 1;
		int[] arr3 = new int[lengthArr3];

		for (int i = 1; i <= lengthArr3; i++) {
			if (lengthshort - i >= 0) {
				sum = leftDigit + shortArr[lengthshort - i] + longArr[lengthlong - i];
				arr3[lengthArr3 - i] = sum % 10;
				leftDigit = sum / 10;
			} else if (lengthlong - i >= 0) {
				sum = leftDigit + longArr[lengthlong - i];
				arr3[lengthArr3 - i] = sum % 10;
				leftDigit = sum / 10;
			} else
				arr3[lengthArr3 - i] = leftDigit;

		}
		return arr3;
	}

	// Question 9
	// Receives square matrix, return max 0 square from left upper side
	public static int max0Rectangle(int[][] mat) {
		int size = mat.length;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (mat[i][j] != 0) {
					if (i > j)
						size = i;
					else
						size = j;
				}
			}
		}
		return size;
	}

	// Question 11
	// shift char left for dir=-1 or right for dir=1, print array before shifting
	public static void shiftCell(char[] arr, int i, int dir) {
		arrayPrint(arr);
		if (dir == 1)
			System.out.println("  MR");
		else
			System.out.println("  ML");
		arr[i + dir] = arr[i];
		arr[i] = '-';
	}

	// shift char 2 cells left for dir=-1 or right for dir=1, print array before
	// shifting
	public static void jumpCell(char[] arr, int i, int dir) {
		arrayPrint(arr);
		if (dir == 1)
			System.out.println("  JR");
		else
			System.out.println("  JL");
		arr[i + 2 * dir] = arr[i];
		arr[i] = '-';
	}

	// Prints given char array with separation
	public static void arrayPrint(char[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " | ");
	}

	// create marble puzzle with given size
	public static char[] marblePuzzlCreator(int size) {
		char[] puzzle = new char[2 * size + 1];
		for (int i = 0; i < 2 * size; i++) {
			if (i % 2 == 0)
				puzzle[i] = '0';
			else
				puzzle[i] = 'X';
		}
		puzzle[2 * size] = '-';
		return puzzle;
	}

	// Receive puzzle size and resolves it
	public static void marblePuzzleSolver(int size) {
		char[] puzzle = marblePuzzlCreator(size);
		int index = 2 * size - 1;
		int shift = 1;
		int jump = 1;
		int iteration = 1;

		while (size - iteration >= 0) {
			shiftCell(puzzle, index, shift);
			for (int i = 0; i < size - iteration; i++) {
				index -= 2 * jump;
				jumpCell(puzzle, index, jump);
			}
			index += jump;
			shift *= -1;
			jump *= -1;
			iteration++;
		}
		arrayPrint(puzzle);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		//Question 1 
//		System.out.println("Enter an integer : ");
//		int num = scanner.nextInt();
//		int increaseNum = increaseByOne(num);
//		System.out.println("New number is: "+increaseNum);

//		//Question 2
//		System.out.println("Enter 2 integers : ");
//		int num1 = scanner.nextInt();
//		int num2 = scanner.nextInt();
//		int newNum = returnMinComination(num1, num2);
//		System.out.println("New number is: "+ newNum);

//		//Question 3
//		boolean isPerfect;
//		for(int i=1;i<=10000;i++)
//		{
//			isPerfect = intIsPerfect(i);
//			if(isPerfect)
//				System.out.println(i);
//		}

//		//Question 4a
//		System.out.println("Enter an integer");
//		int num = scanner.nextInt();
//		int digitSum =  digitsSum(num);
//		System.out.println("The sum of the digits is : " +digitSum);

//		//Question 4b
//		System.out.println("Enter array length :");
//		int arrLength = scanner.nextInt();
//		System.out.println("Enter array of integers");
//		int [] arr = new int [arrLength];
//		for(int i=0; i<arrLength; i++) {
//			arr[i] = scanner.nextInt();
//		}
//		int countEqual10 = digitsSumEqual10(arr, arrLength);
//		System.out.println(countEqual10+" elents digit sum equal to 10");

//		//Question 5
//		System.out.println("Enter number :");
//		int num = scanner.nextInt();
//		System.out.println("Enter char : ");
//		char form = scanner.next().charAt(0);
//		rhombusFrame(num,form);

//		//Question 6
//		System.out.println("Enter matrix dimension :");
//		int matLength = scanner.nextInt();
//		System.out.println("Enter array of integers");
//		int [][] mat = new int [matLength][matLength];
//		for(int i=0; i<matLength; i++) 
//			for(int j=0; j<matLength; j++)
//				mat[i][j] = scanner.nextInt();
//		boolean colRowSumEqual = rowAndColSumIsEqual(mat);
//		System.out.println(colRowSumEqual);

//		//Question 7
//		System.out.println("Enter number of rows :");
//		int rows = scanner.nextInt();
//		System.out.println("Enter number of cols :");
//		int cols = scanner.nextInt();
//		System.out.println("Enter array of integers");
//		int [][] mat = new int [rows][cols];
//		for(int i=0; i<rows; i++) 
//			for(int j=0; j<cols; j++)
//				mat[i][j] = scanner.nextInt();
//		boolean matIsMirror = isMirror(mat,rows,cols);
//		System.out.println(matIsMirror);

//		//Question 8
//		System.out.println("Enter first array dimension :");
//		int arr1Length = scanner.nextInt();
//		int [] arr1 = new int [arr1Length];
//		System.out.println("Enter integers :");
//		for(int i=0;i<arr1Length;i++)
//			arr1[i]= scanner.nextInt();	
//		System.out.println("Enter second array dimension :");
//		int arr2Length = scanner.nextInt();
//		int [] arr2 = new int [arr2Length];
//		System.out.println("Enter integers");
//		for(int i=0;i<arr2Length;i++)
//			arr2[i]= scanner.nextInt();	
//		int [] arr3 = arraysSum(arr1, arr2);
//		for(int i=0;i<arr3.length;i++)
//			System.out.print(arr3[i]+" ");

		// Question 9
//		System.out.println("Enter matrix dimension :");
//		int matLength = scanner.nextInt();
//		System.out.println("Enter array of integers");
//		int [][] mat = new int [matLength][matLength];
//		for(int i=0; i<matLength; i++) 
//			for(int j=0; j<matLength; j++)
//				mat[i][j] = scanner.nextInt();
//		int count0 = max0Rectangle(mat);
//		System.out.println(count0);

		// Question 11
		System.out.println("Enter puzzle size :");
		int puzzleSize = scanner.nextInt();
		marblePuzzleSolver(puzzleSize);

		scanner.close();

	}

}
