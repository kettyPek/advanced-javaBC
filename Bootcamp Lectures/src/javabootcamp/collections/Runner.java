package javabootcamp.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Runner {

	public static void main(String[] args) {

//		List<Integer> list = new ArrayList<Integer>();
//		list.add(3);
//		list.add(5);
//		list.add(8);
//		list.add(10);
//		
//		for(Integer integer : list)
//			System.out.println(integer);
//		System.out.println("--------");
//		
//		Iterator<Integer> iterator = list.iterator();
//				while(iterator.hasNext()) {
//			int i = iterator.next();
//			System.out.println(i);
//		}
//
//		System.out.println("--------");
//		iterator.forEachRemaining(System.out::println);
		
//		//ex1
//		List<String> list1 = new ArrayList<String>();
//		list1.add("item - 1");
//		list1.add("item - 2");
//		list1.add("item - 3");
//	
//		removeAllItemsFromList(list1);
//		
//		System.out.println(list1);
		
		//ex2
		ArrayList<Integer>  input = range(1,10);
		ArrayList<Integer> doubled = double_each(input);
		ArrayList<Integer> complexified = complexify_each(input);
		
		System.out.println(input);
		System.out.println(doubled);
		System.out.println(complexified);

	}
	
	public static void removeAllItemsFromList(List<String> list) {
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}
	
	public static ArrayList<Integer> range(int start,int stop){
		ArrayList<Integer>  arrayList = new ArrayList<Integer>();
		for(int i=start; i<stop; i++){
			arrayList.add(i);
		}
		return arrayList;
	}
	
	public static ArrayList<Integer> double_each(ArrayList<Integer> inlist){
		ArrayList<Integer>  arrayList = new ArrayList<Integer>();
		int multiplyBy = 2;
		Iterator<Integer> iterator = inlist.iterator();
		while(iterator.hasNext()) 
			arrayList.add(multiplyBy*iterator.next());	
		return arrayList;
	}
	
	public static ArrayList<Integer> complexify_each(ArrayList<Integer> inlist) {
		ArrayList<Integer>  arrayList = new ArrayList<Integer>();
		int multiplyBy = 4;
		int add = 3;
		Iterator<Integer> iterator = inlist.iterator();
		while(iterator.hasNext()) 
			arrayList.add(multiplyBy*iterator.next()+add);	
		return arrayList;
	}
	

}
