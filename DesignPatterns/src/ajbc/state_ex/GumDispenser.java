package ajbc.state_ex;

public class GumDispenser {

	private GumDispenserState state;

	public GumDispenser() {
		this.state = new Balance00(this);
	}

	public void changeState(GumDispenserState state) {
		this.state = state;
	}

	public  void updateBalanceBy05() {
		state.updateBalanceBy05();
		state.displayBalnace();
	}

	public void updateBalanceBy10() {
		state.updateBalanceBy10();
		state.displayBalnace();
	}
	
	public void collectGum() {
		state.collectGum();
	}
	
	

}
