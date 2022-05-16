package ajbc.state_ex;

public abstract class GumDispenserState {
	
	protected GumDispenser gumDispenser;

	public GumDispenserState(GumDispenser gumDispenser) {
		this.gumDispenser = gumDispenser;
	}
	
	public abstract void updateBalanceBy05();
	
	public abstract void updateBalanceBy10();
	
	public abstract void collectGum();
	
	public abstract void displayBalnace();
	
	
	
	

}
