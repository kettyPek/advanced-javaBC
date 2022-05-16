package ajbc.state_ex;

public class Balance20 extends GumDispenserState{

	public Balance20(GumDispenser gumDispenser) {
		super(gumDispenser);
	}

	@Override
	public void updateBalanceBy05() {
		gumDispenser.changeState(new Balance25(gumDispenser));
		
	}

	@Override
	public void updateBalanceBy10() {
		System.out.println("Cannot receive more then 25 cents");
	}

	@Override
	public void collectGum() {
		System.out.println("another 5 cents required to purchase a gum");
	}
	
	@Override
	public void displayBalnace() {
		System.out.println("Balance: 20");
		
	}

}
