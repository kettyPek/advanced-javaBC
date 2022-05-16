package ajbc.state_ex;

public class Balance25 extends GumDispenserState{

	public Balance25(GumDispenser gumDispenser) {
		super(gumDispenser);
	}

	@Override
	public void updateBalanceBy05() {
		System.out.println("Please collect the gum");
		
	}

	@Override
	public void updateBalanceBy10() {
		System.out.println("Please collect the gum");
	}

	@Override
	public void collectGum() {
		System.out.println("Enjoy your gum!");
		gumDispenser.changeState(new Balance00(gumDispenser));
	}
	
	@Override
	public void displayBalnace() {
		System.out.println("Balance: 25");
		
	}
	
	

}
