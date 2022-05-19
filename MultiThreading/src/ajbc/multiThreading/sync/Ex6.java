package ajbc.multiThreading.sync;

import java.util.ArrayList;


public class Ex6 {

	static ArrayList<Integer> numbersList = new ArrayList<Integer>();
	static int sum = 0;
	
	public static void main(String[] args) {
		
		final int LIST_SIZE = 50;
		
		for (int i=1; i<=LIST_SIZE; i++) 
			numbersList.add(i);
		
		Thread thread1 = new Thread(new SumHalfEelements(0,LIST_SIZE/2-1));
		Thread thread2 = new Thread(new SumHalfEelements(LIST_SIZE/2,LIST_SIZE-1));
		
		thread1.start();
		thread2.start();
		
		System.out.println("Sum by method is: " + arrayElementsSum());
		System.out.println("Sum by threads is: " + sum);
		
		

	}
	
	static int arrayElementsSum() {
		Integer methodSum = numbersList.stream().reduce(0,(num1,num2) -> num1+num2 );
		return methodSum;
	}
	
	static class SumHalfEelements implements Runnable {
		final int SUM_FROM;
		final int SUM_TO;
		
		public SumHalfEelements(int sumFrom, int sumTo) {
			this.SUM_FROM = sumFrom;
			this.SUM_TO = sumTo;
		}
		
		@Override
		public void run() {
			for(int i=SUM_FROM; i<=SUM_TO; i++)
				sum += numbersList.get(i);
		}
	}
}
