package ajbc.decorator_ex;

public class CasualDecorator extends DressDecorator{

	public CasualDecorator(Dress wrappee) {
		super(wrappee);
	}
	
	@Override
	public void create() {
		super.create();
		System.out.println("Casualness added...");
	}

}
