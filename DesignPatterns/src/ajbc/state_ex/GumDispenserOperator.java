package ajbc.state_ex;

import java.util.Scanner;

public class GumDispenserOperator {
	
	protected GumDispenser gumDispenser;
	Scanner scanner = new Scanner(System.in);
	
	public GumDispenserOperator() {
		gumDispenser = new GumDispenser();
	}
	
	
	
	public void startSimulation() {
		int selection;
		boolean simulationIsOn = true;
		while(simulationIsOn) {
			displyOptions();
			selection = scanner.nextInt();
			switch(selection) {
			case 1:
				gumDispenser.updateBalanceBy05();
				break;
			case 2:
				gumDispenser.updateBalanceBy10();
				break;
			case 3:
				gumDispenser.collectGum();
				break;
			default :
				System.out.println("Simulation endded");
				simulationIsOn = false;
			}
		}
		scanner.close();
	}
	
	private void displyOptions() {
		System.out.println("Welcome to the Gum dispenser simulator, please enter: ");
		System.out.println("1 -  if you're inserting 5 cents coin");
		System.out.println("2 -  if you're inserting 10 cents coin");
		System.out.println("3 -  to collect the gum");
	}

}
