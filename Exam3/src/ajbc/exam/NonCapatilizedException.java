package ajbc.exam;

public class NonCapatilizedException extends Exception {
	
	private String name;
	
	public NonCapatilizedException() {
		super();
		this.name = "name is not capatilized";
	}

}
