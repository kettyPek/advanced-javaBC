package ajbc.adapter_ex;

public abstract class Bird {
	
	protected String sound;
	
	public void fly() {
		System.out.println("Flying");
	}
	
	public void makeSound() {
		System.out.println(sound);
	}
	

}
