package javabootcamp.collections.generic;

import java.util.ArrayList;
import java.util.Collections;

public class GenericClassExample<T> implements GenericInterfaceExample<T> {
	
	private T obj;
	
	public GenericClassExample(T obj) {
	this.obj = obj;	
	}

	@Override
	public ArrayList<T> reverseCopy(ArrayList<T> list) {
		ArrayList<T> reversCopy = new ArrayList<T>(list);
		Collections.reverse(reversCopy);
		return reversCopy;
	}

}
