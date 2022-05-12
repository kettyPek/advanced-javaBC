package ajbc.adapter_ex;

public class Runner {

	public static void main(String[] args) {
		
		Sparrow sparrow = new Sparrow();
		sparrow.fly();
		sparrow.makeSound();
		
		PlastictToyDuck toyDuck = new PlastictToyDuck();
		toyDuck.squeak();
		
		ToyDuck sparrowToyDuck = new BirdToToyDuckAdapter(sparrow);
		sparrowToyDuck.squeak();

	}

}
