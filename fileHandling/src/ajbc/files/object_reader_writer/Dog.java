package ajbc.files.object_reader_writer;

import java.io.Serializable;

public class Dog implements Serializable{
	
	String name;
	String breed;
	
	public Dog(String name, String breed) {
		super();
		this.name = name;
		this.breed = breed;
	}
	
	

}
