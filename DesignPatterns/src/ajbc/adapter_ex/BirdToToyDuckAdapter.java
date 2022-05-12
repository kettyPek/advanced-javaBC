package ajbc.adapter_ex;

public class BirdToToyDuckAdapter extends ToyDuck{
	
	private Bird bird;
	
	public BirdToToyDuckAdapter(Bird bird) {
		this.bird = bird;
	}
	
	@Override
	public void squeak() {
		bird.makeSound();
	}

}
