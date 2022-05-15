package ajbc.command_ex;

import java.util.ArrayList;

public class CommandHistory {
	
	private ArrayList<Command> commandHistory ;
	
	public CommandHistory() {
		commandHistory = new ArrayList<Command>();
	}
	
	public void push(Command command) {
		commandHistory.add(command);
	}
	
	
	public void printHistory(int num) {
		for(int i=num; i>0; i--)
			System.out.println(commandHistory.get(commandHistory.size()-i));
	}
	


}
