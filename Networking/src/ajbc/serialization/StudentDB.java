package ajbc.serialization;

import java.util.HashMap;
import java.util.Map;

public class StudentDB {
	
	private final static Map<Long,Student> students = new HashMap<>() {
		{
			put(10001l, new Student("Alex",20));
			put(10002l, new Student("Dana",21));
			put(10003l, new Student("Ayala",24));
			put(10004l, new Student("Ketty",25));
			put(10005l, new Student("Sheky",26));
		}	
	};
	
	public static Student getStidentByID(long id) {
		return students.get(id);
	}

}
