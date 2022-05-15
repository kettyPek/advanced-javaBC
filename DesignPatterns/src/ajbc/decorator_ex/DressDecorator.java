package ajbc.decorator_ex;

public class DressDecorator implements Dress{
	
	private Dress wrappee;

	
	public DressDecorator(Dress wrappee) {
		this.wrappee = wrappee;
	}


	@Override
	public void create() {
		wrappee.create();	
	}
	
}
