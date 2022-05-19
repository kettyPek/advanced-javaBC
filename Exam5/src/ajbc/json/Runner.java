package ajbc.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class Runner {

	public static void main(String[] args) {
		
		List<House> deserializesHousesList = listOfHousesDeserialization();
		deserializesHousesList.forEach(System.out::println);

	}

	static List<House> listOfHousesDeserialization() {

		List<House> housesList = new ArrayList<House>();

		File file = new File("question2Files/question2.json");

		try (FileReader reader = new FileReader(file)) {

			JsonReader jsonReader = new JsonReader(reader);
			Gson gson = new Gson();
			Type HouseListType = new TypeToken<List<House>>() {}.getType();
			housesList = gson.fromJson(jsonReader, HouseListType);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return housesList;
	}

}
