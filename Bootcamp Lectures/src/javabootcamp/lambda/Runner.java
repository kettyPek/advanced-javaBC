package javabootcamp.lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class Runner {

	public static void main(String[] args) {
		
		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<Person> peopleUnder21 = new ArrayList<Person>();
		
		people.add(new Person("ketty","pekarsky",26));
		people.add(new Person("olga","nimkovsky",46));
		people.add(new Person("dani","kravtsov",28));
		people.add(new Person("nikol","pekarsky",18));
		people.add(new Person("vlad","pekarsky",48));
		
		System.out.println("\nlist of people:");
		people.forEach((person)->System.out.println(person));
		
		System.out.println("\npeople sorted by last name");
		people.sort((p1,p2)-> p1.getLastName().compareTo(p2.getLastName()));
		people.forEach((person)->System.out.println(person));
		
		System.out.println("\npeople with name starting woth o:");
		people.forEach((person)->{if(person.getFirstName().charAt(0)=='o')
									{System.out.println(person);}});
		
		System.out.println("\npeople under 21:");
		people.forEach((person)->{if(person.getAge()<21) peopleUnder21.add(person);});
		peopleUnder21.forEach((person)->System.out.println(person));

	}

}
