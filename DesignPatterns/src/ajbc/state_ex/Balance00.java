package ajbc.state_ex;

public class Balance00 extends GumDispenserState{

	
	public Balance00(GumDispenser gumDispenser) {
		super(gumDispenser);
	}

	@Override
	public void updateBalanceBy05() {	
		gumDispenser.changeState(new Balance05(gumDispenser));
		
	}

	@Override
	public void updateBalanceBy10() {
		gumDispenser.changeState(new Balance10(gumDispenser));
	}

	@Override
	public void collectGum() {
		System.out.println("another 25 cents required to purchase a gum");
		
	}
	
	@Override
	public void displayBalnace() {
		System.out.println("Balance: 00");
		
	}
		
}
