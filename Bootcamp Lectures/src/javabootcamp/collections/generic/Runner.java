package javabootcamp.collections.generic;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		GenericClassExample<Integer> generic = new GenericClassExample<Integer>(4);
		
		ArrayList<Integer> reversedList = generic.reverseCopy(list);
		System.out.println(reversedList);
		

	}

}
