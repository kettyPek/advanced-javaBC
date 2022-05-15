package ajbc.decorator_ex;

public class SportyDecorator extends DressDecorator{

	public SportyDecorator(Dress wrappee) {
		super(wrappee);
	}
	
	@Override
	public void create() {
		super.create();
		System.out.println("Sportiness added...");
	}

}
