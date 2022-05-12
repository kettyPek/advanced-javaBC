//Question 1
//JDK is a software which allow us to develop in Java
//JRE is consist of JVM, It contains a set of libraries and files that JVM uses 
//JVM provides a runtime environment in which Java byteCode can be executed

//Question 2
//The process starts with writing the code, the code compiled to a byteCode in .class file,then
//JVM converts the .class file to a specific machine code and execute it  

package javabootcamp.basic.exam;

public class Runner {
		
	//Question 3
	//Receive nonnegative integer,return true if it palindrome, else return false
	public static boolean isPalindrome(int num) {
		boolean isPalindrome = true;
		int temp = num;
		int numRevers = 0;
		
		while(temp!=0) {
			numRevers=numRevers*10+temp%10;
			temp/=10;
		}
		
		if(numRevers!=num)
			isPalindrome = false;
		return isPalindrome;
	}
	
	//Question 4
	//Receive 2 arrays of integers and return new array that begins with the array with the lowest sum of elements,
	//continues with the other array and ends with a cell for the summation of sums 
	//and a cell for the absolute value of the subtraction of sums
	
	public static int [] concatenationArraysBySum(int [] arr1, int [] arr2) {
		
		int [] concatArr = new int [arr1.length+arr2.length+2];
		int [] biggerSumArr = arr1;
		int [] smallerSumArr = arr2;
		int sum1 = sumOfArray(arr1);
		int sum2 = sumOfArray(arr2);
		
		if(sum1<sum2) {
			biggerSumArr = arr2;
			smallerSumArr = arr1;	
		}
		
		for(int i=0; i<smallerSumArr.length; i++) 
			concatArr[i]=smallerSumArr[i];
		for(int i=0; i<biggerSumArr.length; i++) 
			concatArr[i+smallerSumArr.length] = biggerSumArr[i];
		
		concatArr[concatArr.length-2] = sum1+ sum2;
		concatArr[concatArr.length-1] = (sum1-sum2>0)? sum1-sum2 : sum2-sum1;
		
		return concatArr;
	}
	
	public static int sumOfArray(int [] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum+=arr[i];
		return sum;
	}

	public static void main(String[] args) {
		
//		//Question 3		
//		int num = 12321;
//		boolean ispol = isPalindrome(num);
//		System.out.println(ispol);
		
		//Question 4
		int [] arr1 = {7,8,-4};
		int [] arr2 = {-5,7,3,2};
		int [] concatArr = concatenationArraysBySum(arr1,arr2);
		for(int i=0; i<concatArr.length; i++)
			System.out.print(concatArr[i]+" ");
	}

}
