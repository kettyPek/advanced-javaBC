package javabootcamp.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void run() {

		// -------------------------------------------------------------------//
		// Creating a TreeMap
		// -------------------------------------------------------------------//

		// Creating a TreeMap
		SortedMap<String, String> fileExtensions = new TreeMap<>();

		// Adding new key-value pairs to a TreeMap
		fileExtensions.put("python", ".py");
		fileExtensions.put("c++", ".cpp");
		fileExtensions.put("kotlin", ".kt");
		fileExtensions.put("golang", ".go");
		fileExtensions.put("java", ".java");

		// Printing the TreeMap (Output will be sorted based on keys)
		System.out.println(fileExtensions);

		// -------------------------------------------------------------------//
		// TreeMap with a custom Comparator (Descending Order)
		// -------------------------------------------------------------------//

		// Creating a TreeMap with a Custom comparator (Descending order)
		Comparator<String> descendingComp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		};

		fileExtensions = new TreeMap<>(descendingComp);

		/*
		 * The above TreeMap with custom Comparator can be simply written as -
		 * SortedMap<String, String> fileExtensions = new
		 * TreeMap<>(Comparator.reverseOrder());
		 */

		// Adding new key-value pairs to a TreeMap
		fileExtensions.put("python", ".py");
		fileExtensions.put("c++", ".cpp");
		fileExtensions.put("kotlin", ".kt");
		fileExtensions.put("golang", ".go");
		fileExtensions.put("java", ".java");

		// Printing the TreeMap (The keys will be sorted based on the supplied
		// comparator)
		System.out.println(fileExtensions);

		// -------------------------------------------------------------------//
		// TreeMap with a custom Comparator (Case Insensitive Order)
		// -------------------------------------------------------------------//
		// TreeMap with keys sorted by ignoring case
		fileExtensions = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

		/*
		 * The above statement is the short form of - SortedMap<String, String>
		 * fileExtensions = new TreeMap<>(new Comparator<String>() {
		 * 
		 * @Override public int compare(String s1, String s2) { return
		 * s1.compareToIgnoreCase(s2); } });
		 */

		fileExtensions.put("PYTHON", ".py");
		fileExtensions.put("c++", ".cpp");
		fileExtensions.put("KOTLIN", ".kt");
		fileExtensions.put("Golang", ".go");

		// The keys will be sorted ignoring the case (Try removing
		// String.CASE_INSENSITIVE_ORDER and see the output)
		System.out.println(fileExtensions);

		// -------------------------------------------------------------------//
		// Accessing the entries of a TreeMap
		// -------------------------------------------------------------------//
		TreeMap<Integer, String> employees = new TreeMap<>();

		employees.put(1003, "Michael");
		employees.put(1001, "James");
		employees.put(1002, "David");
		employees.put(1004, "Chris");
		employees.put(1000, "adama");

		System.out.println("Employees map : " + employees);

		// Finding the size of a TreeMap
		System.out.println("Total number of employees : " + employees.size());

		// Check if a given key exists in a TreeMap
		Integer id = 1004;
		if (employees.containsKey(id)) {
			// Get the value associated with a given key in a TreeMap
			String name = employees.get(id);
			System.out.println("Employee with id " + id + " : " + name);
		} else {
			System.out.println("Employee does not exist with id : " + id);
		}

		// Find the first and last entry
		System.out.println("First entry in employees map : " + employees.firstEntry());
		System.out.println("Last entry in employees map : " + employees.lastEntry());

		// Find the entry whose key is just less than the given key
		Map.Entry<Integer, String> employeeJustBelow = employees.lowerEntry(1002);
		System.out.println("Employee just below id 1002 : " + employeeJustBelow);

		// Find the entry whose key is just higher than the given key
		Map.Entry<Integer, String> employeeJustAbove = employees.higherEntry(1002);
		System.out.println("Employee just above id 1002 : " + employeeJustAbove);
		// -------------------------------------------------------------------//
		// Removing Entries from a TreeMap
		// -------------------------------------------------------------------//
		TreeMap<String, String> countryISOCodeMapping = new TreeMap<>();

        countryISOCodeMapping.put("India", "IN");
        countryISOCodeMapping.put("United States of America", "US");
        countryISOCodeMapping.put("China", "CN");
        countryISOCodeMapping.put("United Kingdom", "UK");
        countryISOCodeMapping.put("Russia", "RU");
        countryISOCodeMapping.put("Japan", "JP");

        System.out.println("CountryISOCodeMapping : " + countryISOCodeMapping);

        // Remove the mapping for a given key
        String countryName = "Japan";
        String isoCode = countryISOCodeMapping.remove(countryName);
        if(isoCode != null) {
            System.out.println("Removed (" + countryName + " => " + isoCode + ") from the TreeMap. New TreeMap " + countryISOCodeMapping);
        } else {
            System.out.println(countryName + " does not exist, or it is mapped to a null value");
        }

        // Remove the mapping for the given key only if it is mapped to the given value
        countryName = "India";
        boolean isRemoved = countryISOCodeMapping.remove(countryName, "IA");
        System.out.println("Was the mapping removed for " + countryName + "? : " + isRemoved);

        // Remove the first entry from the TreeMap
        Map.Entry<String, String> firstEntry = countryISOCodeMapping.pollFirstEntry();
        System.out.println("Removed firstEntry : " + firstEntry + ", New TreeMap : " + countryISOCodeMapping);

        // Remove the last entry from the TreeMap
        Map.Entry<String, String> lastEntry = countryISOCodeMapping.pollLastEntry();
        System.out.println("Removed lastEntry : " + lastEntry + ", New TreeMap : " + countryISOCodeMapping);
		
	}
}
