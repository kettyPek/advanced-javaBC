package javabootcamp.basic.arrays;

public class Runner {

	public static void main(String[] args) {
		
		//
//		int [][] arr = {
//				{1,-2,3},
//				{-4,-5,6,9},
//				{7},
//		};
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println("");
//		}
		
//		for(int[] row:arr) {
//			for(int element :row) {
//				System.out.print(element+" ");
//			}
//			System.out.println("");
//		}
		
		//creating copyArr to be originalArr value powered by 2
		int [] originalArr = {5,-1,-2};
		int [] copyArr = new int [originalArr.length];
		for(int i=0;i<originalArr.length;i++) {
			copyArr[i]=originalArr[i]*originalArr[i];
			System.out.print(copyArr[i]+" ");
		}

	}

}
