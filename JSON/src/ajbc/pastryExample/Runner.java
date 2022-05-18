package ajbc.pastryExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import ajbc.pastryExample.Pastry.PastryLable;

/**
 * @author ketty
 *
 */
public class Runner {

	public static void main(String[] args) {

		List<Ingredient> pizzaIngredients = new ArrayList<Ingredient>();
		pizzaIngredients.add(new Ingredient("Flour", 500));
		pizzaIngredients.add(new Ingredient("cheeze", 200));
		pizzaIngredients.add(new Ingredient("Tomatos sauce", 50));
		
		List<Ingredient> croissantIngredients = new ArrayList<Ingredient>();
		croissantIngredients.add(new Ingredient("Flour", 500));
		croissantIngredients.add(new Ingredient("Butter", 200));
		
		List<Ingredient> chocolateCookieIngredients = new ArrayList<Ingredient>();
		chocolateCookieIngredients.add(new Ingredient("Flour", 100));
		chocolateCookieIngredients.add(new Ingredient("Chocolate", 50));

		Pastry pizza = new Pastry("Pizza", 500, PastryLable.DAIRY, pizzaIngredients);
		Pastry croissant = new Pastry("croissant", 300, PastryLable.DAIRY, croissantIngredients);
		Pastry chocolateCookie = new Pastry("chocolateCookie", 100, PastryLable.PARVE, chocolateCookieIngredients);
		
		List<Pastry> pastries = Arrays.asList(pizza,croissant,chocolateCookie);

//		pastrySerialization(pizza);
		Pastry deserializedPastry = pastryDeserialization();
		System.out.println("------Deserialized pastry------");
		System.out.println(deserializedPastry);
		
		listOfPastriesSerialization(pastries);
		List<Pastry> deserializedPastryList = listOfDeserializationPastries();
		System.out.println("\n------List of deserialized pastries------");
		deserializedPastryList.forEach(pastry -> System.out.println(pastry));
		
		Map<PastryLable,List<Pastry>> pastriesMap = pastriesLisToMapByLableKey(pastries);
//		mapPastrySerialization(pastriesMap) ;
		Map<PastryLable,List<Pastry>> pastriesDeserializedMap = mapOfPastriesDeserialization();
		System.out.println("\n------Map of deserialized pastries with Lable as key------");
		pastriesDeserializedMap.entrySet().forEach(System.out::println);
		
	}

	public static void pastrySerialization(Pastry pastry) {

		Gson gson = new Gson();
		String pastryGson = gson.toJson(pastry);

		File file = new File("MyFiles/pasrty.json");

		try (FileWriter writer = new FileWriter(file)) {
			writer.write(pastryGson);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static Pastry pastryDeserialization() {
		File file = new File("MyFiles/pasrty.json");
		Pastry pastry = null;
		try (FileReader fileReader = new FileReader(file)) {
			
			JsonReader jsonReader = new JsonReader(fileReader);
			Gson gson = new Gson();
			pastry = gson.fromJson(jsonReader, Pastry.class);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return pastry;
	}
	
	public static void listOfPastriesSerialization(List<Pastry> pastries) {

		Gson gson = new Gson();
		File file = new File("MyFiles/pasrtyList.json");
		
		try (FileWriter writer = new FileWriter(file)) {
			String pastryGsonList = gson.toJson(pastries);
			writer.write(pastryGsonList);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static List<Pastry> listOfDeserializationPastries() {
		
		List<Pastry> pastries = new ArrayList<Pastry>();

		File file = new File("MyFiles/pasrtyList.json");
		
		try (FileReader reader = new FileReader(file)) {
			
			JsonReader jsonReader = new JsonReader(reader);
			Gson gson = new Gson();
			Type patriesListType = new TypeToken<List<Pastry>>() {}.getType();
			pastries = gson.fromJson(jsonReader, patriesListType);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return pastries;
	}

	public static Map<PastryLable,List<Pastry>> pastriesLisToMapByLableKey(List<Pastry> pastryList){
		return pastryList.stream().collect(
			      Collectors.groupingBy(pastry -> pastry.getLable(), HashMap::new, Collectors.toCollection(ArrayList::new)));
	}
	
	
	
	public static void mapPastrySerialization(Map<PastryLable,List<Pastry>> pastriesMap) {
		
		Gson gson = new Gson();
		File file = new File("MyFiles/pasrtyMap.json");
		
		try (FileWriter writer = new FileWriter(file)) {
			String pastryGsonList = gson.toJson(pastriesMap);
			writer.write(pastryGsonList);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static Map<PastryLable,List<Pastry>> mapOfPastriesDeserialization(){
		Map<PastryLable,List<Pastry>> pastriesMap = new HashMap<PastryLable,List<Pastry>>();
		
		File file = new File("MyFiles/pasrtyMap.json");
		
		try (FileReader reader = new FileReader(file)) {
			
			JsonReader jsonReader = new JsonReader(reader);
			Gson gson = new Gson();
			Type patriesMapType = new TypeToken<Map<PastryLable,List<Pastry>>>(){ }.getType();
			pastriesMap = gson.fromJson(jsonReader, patriesMapType);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		return pastriesMap;
	}
}
