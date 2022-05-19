package ajbc.multiThreading.daemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex4 {
	
	public static void main(String [] args) {
		
		final int NEGATIVE_NUM_INDEX = 1;
		
		List<Integer> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		
		for(int i=0; i<=999; i++) {
			list1.add(i);
			list2.add(i+1000);
		}
		
		list1.set(NEGATIVE_NUM_INDEX, -2);
		
		Collections.sort(list1);
		
		Thread thread1 = new Thread(new NegativeNumFinder(list1),"User thread");
		Thread thread2 = new Thread(new CoomonValuesDetector(list1,list2));
		
		thread2.setDaemon(true);
		
		thread1.start();
		thread2.start();
		
	}
	
	static class NegativeNumFinder implements Runnable{

		private List<Integer> numList;
		
		public NegativeNumFinder(List<Integer> numList) {
			this.numList = numList;
		}
		
		@Override
		public void run() {
			for(var num : numList) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(num<0) {
					System.out.println("Negative value found");
					return;
				}
			}
			System.out.println("Negative value not found");
		}	
	}
	
	static class CoomonValuesDetector implements Runnable{

		private List<Integer> numList1;
		private List<Integer> numList2;
		
		public CoomonValuesDetector(List<Integer> numList1,List<Integer> numList2) {
			this.numList1 = numList1;
			this.numList2 = numList2;
		}
		
		@Override
		public void run() {
			for(var num : numList2) {
				if(Collections.binarySearch(numList1,num) >=0){
					System.out.println("The lists have common element");
					return;
					}
			}
			System.out.println("The lists dont have common elements");
		}	
	}
	

}
