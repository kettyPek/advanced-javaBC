package ajbc.synchronized_keyword;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EXE1 {
	
	static int sum = 0;
	private final int LIST_SIZE = 50;
	private List<Integer> integersList ;
	
	
	public EXE1() {
		integersList = new ArrayList<Integer>();
		makeRandomList();
	}
	
	public int getListSize() {
		return LIST_SIZE;
	}
	
	public List<Integer> getList() {
		return integersList;
	}
	
	private void makeRandomList() {
		int randomNum;
		for (int i = 0; i < LIST_SIZE; i++) {
			randomNum = (int)(Math.random()*(LIST_SIZE+1));
			integersList.add(randomNum);
		}
	}
	
	public int sumOfArray() {
		int sum = 0;
		for(var integer : integersList)
			sum += integer;
		
		return sum;
	}
	
	public static void main(String[] args) {
		EXE1 exe1 = new EXE1();
		
		Lock lock = new ReentrantLock();
		Thread thread1 = new Thread(new SumHalfEelements(0,exe1.getListSize()/2-1,exe1,lock));
		Thread thread2 = new Thread(new SumHalfEelements(exe1.getListSize()/2,exe1.getListSize()-1,exe1,lock));
		
		thread1.start();
		thread2.start();
		
		System.out.println("Sum by method is: " + exe1.sumOfArray());
		System.out.println("Sum by threads is: " + sum);
	}
	
	public void addToSum(int num) {
		sum += num;
	}
	

}
