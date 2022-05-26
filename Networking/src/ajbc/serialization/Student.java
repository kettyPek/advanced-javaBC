package ajbc.serialization;

public class Student {
	
	private static long counter ;
	
	private final long ID;
	private String name;
	private int age;

	static {
		counter = 1000;
	}

	public Student(String name, int age) {
		ID = counter++;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", age=" + age + "]";
	}
	
}
