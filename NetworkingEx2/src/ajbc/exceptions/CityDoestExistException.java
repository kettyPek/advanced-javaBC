package ajbc.exceptions;

public class CityDoestExistException extends Exception{
	
	private String name;
	
	public CityDoestExistException() {
		super();
		name = "City doest exists";
	}

}
