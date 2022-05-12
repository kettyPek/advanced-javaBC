package ajbc.exam;

public class TooYoungException extends RuntimeException {
	
private String name;
	
	public TooYoungException() {
		super();
		this.name = "age too young";
	}

}
