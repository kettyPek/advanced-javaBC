package ajbc.command_ex;

public class HeaterApp {
	
	private CommandHistory commandHistory;
	private Command command;
	private int workingMinutes;
	
	public HeaterApp() {
		commandHistory = new CommandHistory();
	}

	public void turnOn(int workingMinutes) {
		this.workingMinutes = workingMinutes;
		executeCommand(new OnCommand(this));
	}

	public void turnOff() {
		executeCommand(new OffCommand(this));
		
	}
	
	public void showHistory() {
		commandHistory.printHistory(5);
	}
	
	private void executeCommand(Command command) {
		this.command = command;
		command.execute();
		commandHistory.push(command);
	}
	
	public int getWorkingMinutes() {
		return workingMinutes;
	}

}
