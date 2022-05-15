package ajbc.command_ex;

import java.time.LocalTime;

public abstract class Command {
	
	protected HeaterApp app;
	protected LocalTime time;
	
	public Command(HeaterApp app) {
		this.app = app;
	}
	
	
	public abstract void execute();

}
