package ajbc.decorator_ex;

public class BasicDecorator implements Dress{
	
	private String color;
	private String size;

	public BasicDecorator(String color, String size) {
		this.color = color;
		this.size = size;
	}
	
	
	
	@Override
	public String toString() {
		return "[color=" + color + ", size=" + size + "]";
	}


	@Override
	public void create() {
		System.out.println("-------------------");
		System.out.println("Basic dress features: " + toString());
	}
	
	

}
