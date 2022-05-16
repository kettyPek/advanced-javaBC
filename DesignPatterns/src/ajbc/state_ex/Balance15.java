package ajbc.state_ex;

public class Balance15 extends GumDispenserState{

	public Balance15(GumDispenser gumDispenser) {
		super(gumDispenser);
	}

	@Override
	public void updateBalanceBy05() {
		gumDispenser.changeState(new Balance20(gumDispenser));
		
	}

	@Override
	public void updateBalanceBy10() {
		gumDispenser.changeState(new Balance25(gumDispenser));
	}

	@Override
	public void collectGum() {
		System.out.println("another 10 cents required to purchase a gum");
	}
	
	@Override
	public void displayBalnace() {
		System.out.println("Balance: 15");
		
	}

}
