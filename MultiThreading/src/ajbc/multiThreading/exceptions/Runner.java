package ajbc.multiThreading.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	static List<Integer> numbersList;

	static List<Integer> emptyList1;
	static List<String> emptyList2;
	static List<Integer> emptyList3;

	public static void main(String[] args) {

		final int ELEMENTS_AMOUNT = 1000;
		final int MAX_ELEMENT = 10;
		final int REPLACE_AMOUNT = 3;

		numbersList = new ArrayList<Integer>();

		for (int i = 0; i < ELEMENTS_AMOUNT; i++)
			numbersList.add((int) (Math.random() * MAX_ELEMENT));

		int index;
		for (int i = 0; i < REPLACE_AMOUNT; i++) {
			index = (int) (Math.random() * numbersList.size());
			numbersList.set(index, null);
		}

		emptyList1 = new ArrayList<Integer>();
		emptyList2 = new ArrayList<String>();
		emptyList3 = new ArrayList<Integer>();

		Thread thread1 = new Thread(new DoubleListElements(), "Doubled elements thread");
		Thread thread2 = new Thread(new AddoneToElementsAndParseString(), "Doubled elements thread");

		thread2.setUncaughtExceptionHandler((t,  exception) -> {
			System.out.println(exception);
			System.out.println("Empty list2 size: " + emptyList2.size());	
		});
		
		thread1.start();
		thread2.start();
		
	}

	static class DoubleListElements implements Runnable {

		@Override
		public void run() {
			for (var num : numbersList) {
				try {
					emptyList1.add(num * 2);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			System.out.println("Empty list1 size: " + emptyList1.size());
		}
	}
	
	static class AddoneToElementsAndParseString implements Runnable {

		@Override
		public void run() {
			for (var num : numbersList) 
					emptyList2.add(Integer.toString(num+1));

			System.out.println("Empty list2 size: " + emptyList2.size());
		}
	}

}
