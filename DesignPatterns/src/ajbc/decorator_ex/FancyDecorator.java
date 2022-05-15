package ajbc.decorator_ex;

public class FancyDecorator extends DressDecorator{

	public FancyDecorator(Dress wrappee) {
		super(wrappee);
	}
	
	@Override
	public void create() {
		super.create();
		System.out.println("Fancienss added...");
	}

}
