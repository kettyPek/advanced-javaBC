package ajbc.state_ex;

public class Balance10 extends GumDispenserState{

	public Balance10(GumDispenser gumDispenser) {
		super(gumDispenser);
	}

	@Override
	public void updateBalanceBy05() {
		gumDispenser.changeState(new Balance15(gumDispenser));
		
	}

	@Override
	public void updateBalanceBy10() {
		gumDispenser.changeState(new Balance20(gumDispenser));
	}

	@Override
	public void collectGum() {
		System.out.println("another 15 cents required to purchase a gum");
	}

	@Override
	public void displayBalnace() {
		System.out.println("Balance: 10");
		
	}
	
	

}
