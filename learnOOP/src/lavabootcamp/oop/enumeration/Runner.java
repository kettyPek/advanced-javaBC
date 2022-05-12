package lavabootcamp.oop.enumeration;

import lavabootcamp.oop.enumeration.StatusCode.Status;

public class Runner {

	public static void main(String[] args) {
		
		Status status = Status.FAIL;
		
		for(Status st:status.values())
			System.out.println(st.code);
//		Level lev = Level.HIGH;
//		for(Level level : Level.values())
//			System.out.println(level);
			
	}
	
	public static int numByLevel(Level lev) {
		switch(lev) {
		case HIGH:
			return 1;
		case MEDIUM:
			return 2;
		case LOW:
			return 3;	
		}
		return 0;
	}
	
//	public static Level checkTemprature(double temp) {
//		if( temp>100)
//			return Level.HIGH;
//		else
//			Level.LOW;
//	}

}

enum Level{
	LOW, MEDIUM, HIGH
}
